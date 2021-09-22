package com.example.blogger.service;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Connection;
import com.example.blogger.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {
    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private BlogUserService blogUserService;

    public Connection addToConnection(Long blogUserId, Long connectionUserId, Connection connection){
        BlogUser blogUser1 = blogUserService.getUser2(blogUserId);
        BlogUser connectionUser = blogUserService.getUser2(connectionUserId);
        if(!blogUser1.getBlogUser().contains(blogUser1)) {
            connection.setUserConnected(connectionUser);
            connection.setBlogUser(blogUser1);
            Connection connection1 = connectionRepository.save(connection);
            return connection1;
        }else
            return null;
    }
}
