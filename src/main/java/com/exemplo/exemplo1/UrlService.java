package com.exemplo.exemplo1;

import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public LinkResponse createLink(LinkRequest link){
        return new LinkResponse(urlRepository.create(link.getUrl()));
    }

    public String redirect(Integer id){
        return urlRepository.countAccess(id);
    }

    public Integer countAccess(Integer id){
        return urlRepository.getLink(id).getRedirectCount();
    }

    public Link invalidate(Integer id){
        return urlRepository.invalidate(id);
    }
}
