package com.ruge.ruge_blog_semantic.controller.admin;

import com.ruge.ruge_blog_semantic.domain.entitys.Type;
import com.ruge.ruge_blog_semantic.service.TypeService;
import com.ruge.ruge_blog_semantic.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 类型控制器
 * @date 2020/6/5 22:35
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Resource
    private TypeService typeService;

    /**
     * @param pageable {@link Pageable}
     * @param model    {@link Model}
     * @return 跳转到类别页面
     */
    @GetMapping("/types")               //默认size为10，根据id，倒叙排序
    public String typeList(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model) {

        Page<Type> types = typeService.listType(pageable);
        model.addAttribute("page", types);
        return "admin/types";
    }

    /**
     * @return 跳转到类别编辑页面
     */
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("type", type);
        return "admin/types-input";
    }

    /**
     * @param type       {@link Type}
     * @param result     {@link BindingResult}
     * @param attributes {@link RedirectAttributes}
     * @return 新增类型
     */
    @PostMapping("/types")   //@Valid是配合@NotBlank校验是否为空 BindingResult一定要和要校验的参数挨着，不然没效果
    public String addType(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        //后端校验
        String name = type.getName();
        Type dbType = typeService.getTypeByName(name);
        if (dbType != null) {
            result.rejectValue("name", "nameError", "不能重复添加分类");
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }

        try {
            typeService.saveType(type);
            attributes.addFlashAttribute("message", "新增成功");
        } catch (Exception e) {
            attributes.addFlashAttribute("message", "新增失败");
            e.printStackTrace();
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")   //@Valid是配合@NotBlank校验是否为空
    public String editType(Type type, @PathVariable Long id, RedirectAttributes attributes) {

        try {
            typeService.updateType(id, type);
            attributes.addFlashAttribute("message", "更新成功");
        } catch (Exception e) {
            attributes.addFlashAttribute("message", "更新失败");
            e.printStackTrace();
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}
