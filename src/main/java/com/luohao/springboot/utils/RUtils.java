package com.luohao.springboot.utils;

import com.luohao.springboot.R.R;
import com.luohao.springboot.R.Renum;
import com.luohao.springboot.bean.Mybatis_Student;

public class RUtils {
    /**
     * 成功且返回数据
     * @param object 数据
     * @return r
     */
    public static R success(Object object){
        R r=new R();
        r.setCode(Renum.Success.getCode());
        r.setMsg(Renum.Success.getMsg());
        r.setData(object);
        return r;
    }

    /**
     * 成功但是不返回数据
     * @return
     */
    public static R success(){
        return success(null);
    }

    /**
     * 失败返回信息
     * @return
     */
    public static R error(Integer code,String msg){
        R r=new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
