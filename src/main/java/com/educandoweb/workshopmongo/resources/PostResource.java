package com.educandoweb.workshopmongo.resources;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.resources.util.URL;
import com.educandoweb.workshopmongo.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {



    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> findById(Post post) {
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        LocalDate min = URL.convertDate(minDate, LocalDate.of(1970, 1, 1));
        LocalDate max = URL.convertDate(maxDate, LocalDate.now());

        List<Post> posts = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(posts);
    }




}
