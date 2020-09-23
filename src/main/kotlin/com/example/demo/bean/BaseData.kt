package com.example.demo.bean

import org.springframework.stereotype.Repository

@Repository
 class BaseData<T> {
    var  data:T ?=null
}