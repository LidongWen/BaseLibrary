package com.wenld.baselibrary.http;

import com.wenld.baselib.http.HttpUtils;
import com.wenld.baselib.http.callback.EngineCallBack;
import com.wenld.baselibrary.FastJsonUtil;
import com.wenld.baselibrary.io.BaseDataModel;

import okhttp3.Response;



/**
 * Created by Wenld on 2016/06/27.
 */
public abstract class BaseApiCallback extends EngineCallBack<BaseDataModel> {
    @Override
    public BaseDataModel parseNetworkResponse(Object o,final int id) throws Exception {

        Response response = (Response) o;
        final BaseDataModel dataModel = FastJsonUtil.getObject(response.body().string(), BaseDataModel.class);

        HttpUtils.getInstance().getDelivery().execute(new Runnable() {
            @Override
            public void run() {
                onResponse(dataModel,id);
            }
        });

        return dataModel;
    }
}
