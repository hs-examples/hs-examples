package com.example.comservicerestdemo.service.impl;

import com.example.comservicerestdemo.service.RemoteRestClient;
import com.example.comservicerestdemo.service.RemoteService;
import com.example.comservicerestdemo.web.model.UserModel;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class RemoteServiceImpl implements RemoteService {


    private final String serviceId;

    private RestTemplate template;
    private final EurekaClient client;

    private final RemoteRestClient restClient;

    public RemoteServiceImpl(@Value("${remote.spring-data-example.id}") String serviceId, EurekaClient client, RemoteRestClient restClient) {
        this.serviceId = serviceId;
        this.client = client;
        this.restClient = restClient;

        // extract later as bean!
        this.template = new RestTemplate();
    }

//    @Override
//    public List<UserModel> getAllUsers() {
//        List<UserModel> userModelList = new ArrayList<>();
//
//        for (int i = 1; i < 11; i++) {
//            final String homepage = client.getApplication(serviceId).getInstances().get(0).getHomePageUrl();
//            final String url = homepage + "/api/user/" + i;
//            UserModel model = template.getForEntity(url, UserModel.class).getBody();
//            model.setUrl(url);
//
//            userModelList.add(model);
//        }
//
//
//        return userModelList;
//    }

    /**
     * analog zu #getAllUsers()
     * nur wird hier der "FeignClient" verwendet, statt "RestTemplate"
     *
     * @return
     */
    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> userModelList = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            UserModel model = restClient.findUserById((long) i);
            userModelList.add(model);
        }


        return userModelList;
    }
}
