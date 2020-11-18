package com.starryriver.galaxy.view.Contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.starryriver.galaxy.R;
import com.starryriver.galaxy.databinding.FragmentContactBinding;

/**
 * @author : StarryRivers
 * Project  : Galaxy
 * Desc     : 好友
 * @date : 2020/11/17 20:01
 */
public class ContactFragment extends Fragment {
    private FragmentContactBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false);
        return binding.getRoot();
    }
}
