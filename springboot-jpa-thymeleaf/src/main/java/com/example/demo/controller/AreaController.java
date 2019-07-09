package com.example.demo.controller;

import com.example.demo.dao.AreaRepository;
import com.example.demo.entity.TbAreaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AreaController {
    @Autowired
    AreaRepository areaSQL;

    @ResponseBody
    @RequestMapping("/find2")
    public Map<String,Object>  findAll2(){
        Map<String,Object> model= new HashMap<String,Object>() ;
        model.put("areas",areaSQL.findAll());
        return model;
    }
    @GetMapping("/find3")
    public String findAll3(Model model) {
        model.addAttribute("msg","Spring boot and Thymeleaf-->to redit.html");
        model.addAttribute("areas", areaSQL.findAll());
        return "index";  //在templates中寻找addArea.html,而不会陷入循环
    }

    @GetMapping("/regit")
    public String addArea(Model model) {
        model.addAttribute("area",new TbAreaEntity());
        return "regit";
    }
    @RequestMapping(value = "/regit",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String addArea(@Valid TbAreaEntity area, Model model,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {  // in com..Entity @NotEmpty  @Size(min=2, max=30)  and @Valid

            return "regit";   //@ModelAttribute Area area --https://www.cnblogs.com/zhangshitong/p/5342076.html
        }else{
            //Map<String,Object> model= new HashMap<String,Object>() ;
            model.addAttribute("regit","regit success:"+areaSQL.save(area));
            areaSQL.save(area);//Model model;
            return findAll3(model);
        }
    }

    @ResponseBody
    @RequestMapping("/del")     //del?id=2
    public String del(@Param("areaId") Integer id){
        areaSQL.deleteBy_Id(id);
        return areaSQL.existsById(id)?"failed":"success";
    }
    @ResponseBody
    @RequestMapping("/fin")
    public Map<String, Object> fin(@Param("areaId") Integer id){
        Map<String,Object> model= new HashMap<String,Object>() ;
        model.put("areas", areaSQL.findBy_id(id));
        return model;
    }
}
