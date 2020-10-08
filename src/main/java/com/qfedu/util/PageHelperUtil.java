package com.qfedu.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/7 11:29
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHelperUtil {
    private Long count;
    private String msg;
    private Integer code;
    private Object data;

    public PageHelperUtil(Long count,Object data){
        this.count = count;
        this.data = data;
    }

    public static PageHelperUtil success(Long count,Object data){
        return new PageHelperUtil(count,"",0,data);
    }

}
