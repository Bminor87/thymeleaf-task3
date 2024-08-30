package com.hellmanstudios.friendform.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hellmanstudios.friendform.domain.Friend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class FriendController {

    public List<Friend> friends;

    public FriendController() {
        this.friends = new ArrayList<Friend>();
        this.friends.add(new Friend("Jesse", "Hellman"));
    }

    @GetMapping("add")
    public String addFriendForm() {
        return "add";
    }

    @PostMapping("add")
    public String addFriend(@RequestBody String firstName, @RequestBody String lastName) {

        return "redirect: list";
    }

    @GetMapping("list")
    public String listFriends(Model model) {
        model.addAttribute("friends", friends);
        return "list";
    }

}
