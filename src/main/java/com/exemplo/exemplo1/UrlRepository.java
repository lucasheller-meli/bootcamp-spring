package com.exemplo.exemplo1;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UrlRepository {
    private Map<Integer, Link> links = new HashMap<>();
    private Integer nextId = 0;

    public Integer create(String url){
        links.put(nextId, new Link(url, nextId, 0, true));
        return nextId++;
    }

    public String countAccess(Integer id){
        Link link = links.get(id);
        if(link == null){
            throw new LinkNotFoundException("LinkId not found: " + id);
        }
        link.setRedirectCount(link.getRedirectCount() + 1);
        return link.getUrl();
    }

    public Link getLink(Integer id){
        return links.get(id);
    }

    public Link invalidate(Integer id){
        Link link = links.get(id);
        link.setValid(false);
        return link;
    }
}
