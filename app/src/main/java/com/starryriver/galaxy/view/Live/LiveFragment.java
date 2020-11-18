package com.starryriver.galaxy.view.Live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.starryriver.galaxy.R;
import com.starryriver.galaxy.databinding.FragmentLiveBinding;

/**
 * @author : StarryRivers
 * Project  : Galaxy
 * Desc     : TODO
 * @date : 2020/11/17 20:36
 */
public class LiveFragment extends Fragment {
    private FragmentLiveBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_live, container, false);
        return binding.getRoot();
    }
}
