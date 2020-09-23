package com.example.demo.bean

import org.springframework.stereotype.Repository

/**
 * 数据接收类
 * 使用的是 body
 */
@Repository
 class BaseData<T> {
    var  data:T ?=null
}