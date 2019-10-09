package com.ls.rjianzye.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ls.rjianzye.R;
import com.ls.rjianzye.fragment.CartFragment;
import com.ls.rjianzye.fragment.CategoryFragment;
import com.ls.rjianzye.fragment.HomeFragment;
import com.ls.rjianzye.fragment.PersonalFragment;

public class NavigationFragment extends Fragment {

    private ImageView iv_home;
    private ImageView iv_category;
    private ImageView iv_cart;
    private ImageView iv_personal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        iv_home = view.findViewById(R.id.iv_home);
        iv_category = view.findViewById(R.id.iv_category);
        iv_cart = view.findViewById(R.id.iv_cart);
        iv_personal = view.findViewById(R.id.iv_personal);

        reseImageResource(iv_home);
        showFragment(iv_home);

        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_home);
                reseImageResource(iv_home);
            }
        });
        iv_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_category);
                reseImageResource(iv_category);
            }
        });
        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_cart);
                reseImageResource(iv_cart);
            }
        });
        iv_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_personal);
                reseImageResource(iv_personal);
            }
        });
    }

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private CartFragment cartFragment;
    private PersonalFragment personalFragment;

    private void showFragment(ImageView focus2) {
        FragmentManager manger = getFragmentManager();

        FragmentTransaction transaction = manger.beginTransaction();

        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (categoryFragment != null) {
            transaction.hide(categoryFragment);
        }
        if (cartFragment != null) {
            transaction.hide(cartFragment);
        }
        if (personalFragment != null) {
            transaction.hide(personalFragment);
        }
        if (focus2.getId() == R.id.iv_home) {
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
                transaction.add(R.id.fl_2, homeFragment);
            } else {
                transaction.show(homeFragment);
            }

        }
        if (focus2.getId() == R.id.iv_category) {
            if (categoryFragment == null) {
                categoryFragment = new CategoryFragment();
                transaction.add(R.id.fl_2, categoryFragment);
            } else {
                transaction.show(categoryFragment);
            }

        }
        if (focus2.getId() == R.id.iv_cart) {
            if (cartFragment == null) {
                cartFragment = new CartFragment();
                transaction.add(R.id.fl_2, cartFragment);
            } else {
                transaction.show(cartFragment);
            }

        }
        if (focus2.getId() == R.id.iv_personal) {
            if (personalFragment == null) {
                personalFragment = new PersonalFragment();
                transaction.add(R.id.fl_2, personalFragment);
            } else {
                transaction.show(personalFragment);
            }
        }
        transaction.commit();
    }

    private void reseImageResource(ImageView focus1) {
        iv_home.setImageResource(R.mipmap.tab_item_home_normal);
        iv_category.setImageResource(R.mipmap.tab_item_category_normal);
        iv_cart.setImageResource(R.mipmap.tab_item_cart_normal);
        iv_personal.setImageResource(R.mipmap.tab_item_personal_normal);

        if (focus1.getId() == R.id.iv_home) {
            iv_home.setImageResource(R.mipmap.tab_item_home_focus);
        } else if (focus1.getId() == R.id.iv_category) {
            iv_category.setImageResource(R.mipmap.tab_item_category_focus);
        } else if (focus1.getId() == R.id.iv_cart) {
            iv_cart.setImageResource(R.mipmap.tab_item_cart_focus);
        } else if (focus1.getId() == R.id.iv_personal) {
            iv_personal.setImageResource(R.mipmap.tab_item_personal_focus);
        }
    }
}

