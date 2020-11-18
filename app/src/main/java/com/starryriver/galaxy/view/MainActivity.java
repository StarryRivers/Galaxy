package com.starryriver.galaxy.view;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.starryriver.galaxy.BaseActivity;
import com.starryriver.galaxy.R;
import com.starryriver.galaxy.databinding.ActivityMainBinding;
import com.starryriver.galaxy.view.Contact.ContactFragment;
import com.starryriver.galaxy.view.Conversation.ConversationFragment;
import com.starryriver.galaxy.view.Live.LiveFragment;
import com.starryriver.galaxy.view.ProfileSelf.MineFragment;
import com.starryriver.galaxy.viewmodel.MainViewModel;

/**
 * @author : StarryRivers
 * Project  : 星河
 * Desc     : MainActivity
 * @date : 2020/11/5 18:47
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding mainBinding;
    private MainViewModel mainViewModel;
    // 当前的页面
    private Fragment currentFragment;
    // 上次显示的Tab
    private View mLastTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initView();
    }

    private void initView() {
        // 默认打开聊天页
        getSupportFragmentManager().beginTransaction()
                .replace(mainBinding.rlContainer.getId(), new ConversationFragment())
                .commitAllowingStateLoss();
        if (mLastTab == null) {
            // mLastTab为空默认设置为聊天页面
            mLastTab = mainBinding.rlConversationGroup;
        } else {
            // 非空，可能是从后台切回前台，需要显示原来的Tab (初始化时，强制切换tab到上一次的位置)
            View tmp = mLastTab;
            mLastTab = null;
            switchTabClick(tmp);
            mLastTab = tmp;
            switchTabClick(mLastTab);
        }
//        mainViewModel.getMpData();
//        mainBinding.rvMain.setAdapter(mainViewModel.mainAdapter);
        /*mainBinding.rlConversationGroup.setOnClickListener(this);
        mainBinding.rlContactGroup.setOnClickListener(this);
        mainBinding.rlLiveGroup.setOnClickListener(this);
        mainBinding.rlMeGroup.setOnClickListener(this);*/
    }

    /**
     * 实现监听有三种方式，这里采用第一种
     * 1. 在布局中通过onClick属性，方法必须是public
     * 2. 实现onClickListener监听接口
     * 3. 匿名的监听接口
     *
     * @param v view
     */
    public void switchTabClick(View v) {
        if (mLastTab != null && mLastTab.getId() == v.getId()) {
            return;
        }
        mLastTab = v;
        initBottomNavigationStyle();
        switch (v.getId()) {
            case R.id.rl_conversation_group: {
                mainBinding.tvConversation.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
                mainBinding.tvConversation.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.conversation_selected), null, null);
                currentFragment = new ConversationFragment();
                break;
            }
            case R.id.rl_contact_group: {
                mainBinding.tvContact.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
                mainBinding.tvContact.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.contact_selected), null, null);
                currentFragment = new ContactFragment();
                break;
            }
            case R.id.rl_live_group: {
                mainBinding.tvLive.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
                mainBinding.tvLive.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.live_selected), null, null);
                currentFragment = new LiveFragment();
                break;
            }
            case R.id.rl_me_group: {
                mainBinding.tvMine.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
                mainBinding.tvMine.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.myself_selected), null, null);
                currentFragment = new MineFragment();
                break;
            }
            default:
                break;
        }
        // isAdded()是该Fragment是否被添加到Activity中，如果是返回true，否则返回false
        if (currentFragment != null && !currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().replace(mainBinding.rlContainer.getId(), currentFragment).commitAllowingStateLoss();
            // 马上执行替换
            getSupportFragmentManager().executePendingTransactions();
        } else {
            Log.w(TAG, "switchTabClick: Fragment is Added!");
        }
    }

    /**
     * 初始化底部导航栏样式
     */
    private void initBottomNavigationStyle() {
        mainBinding.tvConversation.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
        mainBinding.tvConversation.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.conversation_normal), null, null);
        mainBinding.tvContact.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
        mainBinding.tvContact.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.contact_normal), null, null);
        mainBinding.tvLive.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
        mainBinding.tvLive.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.live_normal), null, null);
        mainBinding.tvMine.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
        mainBinding.tvMine.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.myself_normal), null, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLastTab = null;
    }
}
