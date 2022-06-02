package com.luohao.springboot.utils;

import com.luohao.springboot.R.R;
import com.luohao.springboot.R.Renum;

public class RUtils {
    /**
     * 成功且返回数据
     * @param object 数据
     * @return r
     */
    public static R<Object> success(Object object){
        R<Object> r=new R<>();
        r.setCode(Renum.Success.getCode());
        r.setMsg(Renum.Success.getMsg());
        r.setData(object);
        return r;
    }

    /**
     * 成功但是不返回数据
     * @return
     */
    public static R<Object> success(){
        return success(null);
    }

    /**
     * 失败返回信息
     * @return
     */
    public static R<Object> error(Integer code,String msg){
        R<Object> r=new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    //根据code获取msg
    public static <T> String getmsg(Class<T> renum, int code){
        T[] RenumArray = renum.getEnumConstants();
        for(T r:RenumArray){
            Renum R = (Renum)r;
            if(R.getCode()==code){
                return R.getMsg();
            }
        }
        return null;
    }
}
