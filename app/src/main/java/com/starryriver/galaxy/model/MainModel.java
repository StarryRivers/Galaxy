package com.starryriver.galaxy.model;

import com.starryriver.galaxy.base.BaseData;
import com.starryriver.galaxy.bean.MpBean;
import com.starryriver.galaxy.http.HttpConfig;
import com.starryriver.galaxy.http.MpSerivce;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : StarryRivers
 * Project  : 星河
 * Desc     : Model
 * @date : 2020/11/5 20:20
 */
public class MainModel {
    private static MainModel mainModel;
    private Retrofit retrofit = new Retrofit.Builder().
            baseUrl(HttpConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    private MainModel() {
    }

    public static MainModel getInstance() {
        if (mainModel == null) {
            synchronized (MainModel.class) {
                if (mainModel == null) {
                    mainModel = new MainModel();
                }
            }
        }
        return mainModel;
    }

    /**
     * get the proxy object of MpService
     * get the observable of proxy object
     * build a subscription relationship
     * @param observer observer
     */
    public void subscribe(Observer<BaseData<List<MpBean>>> observer) {
        retrofit.create(MpSerivce.class).getListData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
