package com.starryriver.galaxy.http;

import com.starryriver.galaxy.base.BaseData;
import com.starryriver.galaxy.bean.MpBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

/**
 * @author : StarryRivers
 * Project  : 星河
 * Desc     : request Media Platform data api
 * @date : 2020/11/5 19:52
 */
public interface MpSerivce {

    /**
     * request MP data
     * @return MP list
     */
    @GET("wxarticle/chapters/json")
    Observable<BaseData<List<MpBean>>> getListData();
}
