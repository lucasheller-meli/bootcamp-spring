package com.exemplo.exemplo1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    private String url;
    private Integer id;
    private Integer redirectCount;
    private Boolean valid;
}
