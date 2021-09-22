package com.example.blogger.controller;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Connection;
import com.example.blogger.service.CommentService;
import com.example.blogger.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connection")
public class ConnectionController {
    @Autowired
    private ConnectionService connectionService;
    @PostMapping("/{blogUser}/{connectionUserId}")
    public Connection addConnection(@PathVariable Long blogUser, @PathVariable Long connectionUserId, @RequestBody Connection connection){
    Connection connection1 = connectionService.addToConnection(blogUser, connectionUserId, connection);
    return connection1;
    }
}
