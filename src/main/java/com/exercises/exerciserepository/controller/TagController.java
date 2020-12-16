package com.exercises.exerciserepository.controller;

import com.exercises.exerciserepository.Dao.TagDao;
import com.exercises.exerciserepository.domain.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping (path = "/tag")
public class TagController {

    private final TagDao tagDao;

    TagController(TagDao tagDao){
        this.tagDao = tagDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Tag tag = new Tag();
        tag.setTagName("tag testowy");
        tagDao.saveTag(tag);
        return "Id dodanego tagu:"
                + tag.getId();
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Tag tag = tagDao.findById(id);
        return tag.toString();
    }

    @GetMapping("/update/{id}/{name}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String name) {
        Tag tag = tagDao.findById(id);
        tag.setTagName(name);
        tagDao.update(tag);
        return tag.toString();
    }


    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Tag tag = tagDao.findById(id);
        tagDao.delete(tag);
        return "usunięto";
    }

    @GetMapping("/findall")
    @ResponseBody
    public String findall() {
        List<Tag> allBooks = tagDao.findall();
        return allBooks.stream()
                .map(Tag::getTagName)
                .collect(Collectors.joining("<br>"));
    }


}
