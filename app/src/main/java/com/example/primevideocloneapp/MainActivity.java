package com.example.primevideocloneapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.primevideocloneapp.adapter.BannerMoviesPagerAdapter;
import com.example.primevideocloneapp.adapter.MainRecyclerAdapter;
import com.example.primevideocloneapp.modal.AllCategory;
import com.example.primevideocloneapp.modal.BannerMovies;
import com.example.primevideocloneapp.modal.CategoryItem;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab,categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "PONMANGAL VANDHAL", "http://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner1.png", ""));
        homeBannerList.add(new BannerMovies(2, "Little Women", "http://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner2.png", ""));
        homeBannerList.add(new BannerMovies(3, "BHOOT The Haunted Ship", "http://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner3.png", ""));
        homeBannerList.add(new BannerMovies(4, "MIRZAPUR", "http://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner4.png", ""));
        homeBannerList.add(new BannerMovies(5, "PIKACHU", "http://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner5.png", ""));
        setBannerMoviesPagerAdapter(homeBannerList);

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"PatalLOk","",""));
        homeCatListItem1.add(new CategoryItem(2,"","",""));
        homeCatListItem1.add(new CategoryItem(3,"","",""));
        homeCatListItem1.add(new CategoryItem(4,"","",""));
        homeCatListItem1.add(new CategoryItem(5,"","",""));
        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Watch next TV & Movies", homeCatListItem1));
     //   allCategoryList.add(new AllCategory(2 ,"Movies In Hindi"));
     //   allCategoryList.add(new AllCategory(3,"Kids & Family Shows"));
       // allCategoryList.add(new AllCategory(4,"Amazon Original Series"));
        setMainRecyclerAdapter(allCategoryList);
    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);

        indicatorTab.setupWithViewPager(bannerMoviesViewPager);
       /* Timer slideTimer = new Timer();
        slideTimer.scheduleAtFixedRate(new AutoSlider(), 4000,6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager, true);*/
    }
   // class AutoSlider extends TimerTask{

     //   @Override
       // public void run() {
         //   MainActivity.this.runOnUiThread(new Runnable() {
           //     @Override
             //   public void run() {

 //                       if (bannerMoviesViewPager.setCurrentItem() < homeBannerList.size() - 1){
   //                         bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
//                        }
     //                   else{
       //                     bannerMoviesViewPager.setCurrentItem();
         //               }
    //            }
     //           });
     //   }
   // }

    public void setMainRecyclerAdapter(List<AllCategory> allCategoryList) {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }
}