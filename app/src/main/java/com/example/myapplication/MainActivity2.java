package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.adapter.BannerMoviesPagerAdapter;
import com.example.myapplication.adapter.MainRecyclerAdapter;
import com.example.myapplication.model.AllCategory;
import com.example.myapplication.model.BannerMovies;
import com.example.myapplication.model.Categoryitem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {
    TabLayout categoryTab, tabLayout;
    private TabLayoutMediator tabLayoutMediator;
    private Button logout;

    private BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    private ViewPager2 bannerMoviesViewPager;
    private List<BannerMovies> homeBannerList;
    private List<BannerMovies> movieBannerList;

    private List<BannerMovies> tvShowBannerList;
    private List<BannerMovies> kidsBannerList;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logout = findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });
        tabLayout = findViewById(R.id.tab_indicator);
        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "Movie 1", "https://media.discordapp.net/attachments/864022028952010763/1120372248818233454/wp8872767.png?width=1432&height=662", "https://firebasestorage.googleapis.com/v0/b/stream-eebf3.appspot.com/o/AQUAMAN%202_%20The%20Lost%20Kingdom%20%E2%80%93%20First%20Trailer%20(2023)%20Jason%20Momoa%20Movie%20_%20Warner%20Bros%20(HD).mp4?alt=media&token=9ef8086f-9086-49ad-b9ea-18c90ec4167c"));
        homeBannerList.add(new BannerMovies(2, "Movie 2", "https://media.discordapp.net/attachments/864022028952010763/1120375412367827025/HD-wallpaper-game-of-thrones-tv-series-2011-poster-black-man-collage-girl-actress-tv-series-daenerys-targaryen-actor-game-of-throne-thumbnail.png?width=422&height=237", "https://firebasestorage.googleapis.com/v0/b/stream-eebf3.appspot.com/o/AQUAMAN%202_%20The%20Lost%20Kingdom%20%E2%80%93%20First%20Trailer%20(2023)%20Jason%20Momoa%20Movie%20_%20Warner%20Bros%20(HD).mp4?alt=media&token=9ef8086f-9086-49ad-b9ea-18c90ec4167c"));
        homeBannerList.add(new BannerMovies(3, "Movie 3", "https://media.discordapp.net/attachments/864022028952010763/1120372405769085049/873-8730038_monday-night-movie-star-is-born-poster-landscape.png?width=1025&height=551", ""));
        homeBannerList.add(new BannerMovies(4, "Movie 4", "https://media.discordapp.net/attachments/864022028952010763/1120374902973812816/best-kids-movies-us-netflix-mulan.png?width=958&height=538", ""));
        homeBannerList.add(new BannerMovies(5, "Movie 5", "https://media.discordapp.net/attachments/864022028952010763/1120375989113983097/desktop-wallpaper-swaragini-tv-serial-poster-cover-itl-cat.png?width=1062&height=597", ""));

        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1, "Movie 1", "https://media.discordapp.net/attachments/864022028952010763/1120376034714472539/7NOeYe0.png?width=800&height=470", ""));
        tvShowBannerList.add(new BannerMovies(2, "Movie 1", "https://media.discordapp.net/attachments/864022028952010763/1120376376638308382/desktop-wallpaper-friends-tv-show-friends-pc.png?width=1062&height=597", ""));
        tvShowBannerList.add(new BannerMovies(3, "Movie 1", "https://media.discordapp.net/attachments/864022028952010763/1120375810872844308/PeakyBlinders-ShelbyBrothersLtd1919-NetflixTVShow-FanArtPoster_7b8ef6f8-b3bf-41c9-9f8a-45aca5d68217.png?width=937&height=662", ""));
        tvShowBannerList.add(new BannerMovies(4, "Movie 1", "https://media.discordapp.net/attachments/864022028952010763/1120375412367827025/HD-wallpaper-game-of-thrones-tv-series-2011-poster-black-man-collage-girl-actress-tv-series-daenerys-targaryen-actor-game-of-throne-thumbnail.png?width=422&height=237", ""));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1, "Movie 1", "https://media.discordapp.net/attachments/864022028952010763/1120374218941550732/maeve-althea-control-movie-poster-5fe.png?width=1227&height=662", ""));
        movieBannerList.add(new BannerMovies(2, "Movie 2", "https://media.discordapp.net/attachments/864022028952010763/1120374307286155357/1512312.png?width=1440&height=605", ""));
        movieBannerList.add(new BannerMovies(3, "Movie 3", "https://media.discordapp.net/attachments/864022028952010763/1120372248818233454/wp8872767.png?width=1432&height=662", ""));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1, "Kids 1", "https://media.discordapp.net/attachments/864022028952010763/1120374501490827394/large-rio-movie-poster-non12x18no1x0140-original-imag3pb3aevzfqhh.png?width=1060&height=662", ""));
        kidsBannerList.add(new BannerMovies(2, "Kids 2", "https://media.discordapp.net/attachments/864022028952010763/1120374847005003928/best-kids-movies-netflix-bee-movie.png?width=883&height=662", ""));
        kidsBannerList.add(new BannerMovies(3, "Kids 3", "https://media.discordapp.net/attachments/864022028952010763/1120374799198334976/best-kids-movies-us-netflix-casper.png?width=883&height=662", ""));
        kidsBannerList.add(new BannerMovies(4, "Kids 4", "https://media.discordapp.net/attachments/864022028952010763/1120375093403603014/mural2_40615.png?width=1022&height=530", ""));
        kidsBannerList.add(new BannerMovies(5, "Kids 5", "https://media.discordapp.net/attachments/864022028952010763/1120375034582679722/list-of-1990s-films-free-willy.png?width=750&height=448", ""));

        setBannerMoviesPagerAdapter(homeBannerList);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nested_scroll);

        appBarLayout = findViewById(R.id.appbar);


        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        setScrollDefaultState();
                        break;
                    case 2:
                        setBannerMoviesPagerAdapter(movieBannerList);
                        setScrollDefaultState();

                        break;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        setScrollDefaultState();

                        break;
                    default:
                        setBannerMoviesPagerAdapter(homeBannerList);
                        setScrollDefaultState();

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        List<Categoryitem> homeCatListItem1 =new ArrayList<>();
        homeCatListItem1.add(new Categoryitem(1,"oppenheimer","https://cdn.discordapp.com/attachments/1022525815767961650/1128710813201485844/oppenheimer.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem1.add(new Categoryitem(2,"NUN","https://cdn.discordapp.com/attachments/1022525815767961650/1128710813725757620/nun.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/THE%20NUN%20-%20Official%20Teaser%20Trailer%20%5BHD%5D.mp4?alt=media&token=2a4175f8-21fe-4219-baf4-0b8ae7a1d176"));
        homeCatListItem1.add(new Categoryitem(3,"Jailer","https://cdn.discordapp.com/attachments/1022525815767961650/1128710812836565022/jailer.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback%20(1).mp4?alt=media&token=d8c71975-b011-476a-a995-18700d3eb95b"));
        homeCatListItem1.add(new Categoryitem(4,"Tiger 3","https://cdn.discordapp.com/attachments/1022525815767961650/1128710813461528617/tiger_3.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/Tiger%203%20_%20Date%20Announcement%20_%20Salman%20Khan%2C%20Katrina%20Kaif%20_%20In%20Cinemas%20_%20Diwali%202023.mp4?alt=media&token=7e2723a3-b938-4227-aa3c-8127ff93f252"));
        homeCatListItem1.add(new Categoryitem(5,"Bawaal","https://cdn.discordapp.com/attachments/1022525815767961650/1128710812584919081/bawaal.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/Bawaal%20-%20Official%20Trailer%20_%20Varun%20Dhawan%2C%20Janhvi%20Kapoor%20_%20Prime%20Video%20India.mp4?alt=media&token=b31d21ad-8720-4bd2-94ff-462a076b80bd"));

        List<Categoryitem> homeCatListItem2 =new ArrayList<>();
        homeCatListItem2.add(new Categoryitem(1,"3 idiots","https://cdn.discordapp.com/attachments/1022525815767961650/1128706880341028974/3_idiots.jpg?width=416&height=188","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/MONUMENT%20-%20Cinematic%20Trailer%20Sound%20Effects.mp4?alt=media&token=bceec979-79d6-409d-a0d7-d8b68ff00ce3"));
        homeCatListItem2.add(new Categoryitem(2,"Pathaan","https://cdn.discordapp.com/attachments/1022525815767961650/1128706880710119454/Pathaan_film_poster.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/MONUMENT%20-%20Cinematic%20Trailer%20Sound%20Effects.mp4?alt=media&token=bceec979-79d6-409d-a0d7-d8b68ff00ce3"));
        homeCatListItem2.add(new Categoryitem(3,"Devdas","https://cdn.discordapp.com/attachments/1022525815767961650/1128706881112780910/devdas.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback%20(1).mp4?alt=media&token=d8c71975-b011-476a-a995-18700d3eb95b"));
        homeCatListItem2.add(new Categoryitem(4,"Happy New Year","https://cdn.discordapp.com/attachments/1022525815767961650/1128706881418973245/HNY.jpg?width=993&height=662","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem2.add(new Categoryitem(5,"Sholay","https://cdn.discordapp.com/attachments/1022525815767961650/1128706881725141262/sholay.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));

        List<Categoryitem> homeCatListItem3 =new ArrayList<>();
        homeCatListItem3.add(new Categoryitem(1,"toy story","https://cdn.discordapp.com/attachments/1022525815767961650/1128708446150201446/toy_story.jpg?width=416&height=188","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem3.add(new Categoryitem(2,"cars","https://cdn.discordapp.com/attachments/1022525815767961650/1128708446494138398/p_cars_19643_4405006d.jpeg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem3.add(new Categoryitem(3,"Karate Kid","https://cdn.discordapp.com/attachments/1022525815767961650/1128708446796140655/190694_KarateKid_2010_1400x2100_UK.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem3.add(new Categoryitem(4,"Angry Birds","https://cdn.discordapp.com/attachments/1022525815767961650/1128708447102308462/angry_birds.jpg?width=993&height=662","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem3.add(new Categoryitem(5,"Boss Baby","https://cdn.discordapp.com/attachments/1022525815767961650/1128708447379136674/boss_baby.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));

        List<Categoryitem> homeCatListItem4 =new ArrayList<>();
        homeCatListItem4.add(new Categoryitem(1,"Farzi","https://cdn.discordapp.com/attachments/1022525815767961650/1128717370190479500/farzi.jpg?width=416&height=188","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem4.add(new Categoryitem(2,"Rings Of Power","https://cdn.discordapp.com/attachments/1022525815767961650/1128717370546999408/rings_of_power.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem4.add(new Categoryitem(3,"Jack Ryan","https://cdn.discordapp.com/attachments/1022525815767961650/1128717370882539612/jack_ryan.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem4.add(new Categoryitem(4,"Mirzapur","https://cdn.discordapp.com/attachments/1022525815767961650/1128717369397752032/mirzapur.jpg?width=993&height=662","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));
        homeCatListItem4.add(new Categoryitem(5,"Family Man","https://cdn.discordapp.com/attachments/1022525815767961650/1128717371197116496/family_man.jpg?width=1200&height=600","https://firebasestorage.googleapis.com/v0/b/tran-df344.appspot.com/o/videoplayback.mp4?alt=media&token=85a40c62-0395-4bb5-a81e-fef5497d696c"));

        List<Categoryitem> homeCatListItem5 =new ArrayList<>();
        homeCatListItem5.add(new Categoryitem(1,"FIR","https://media.discordapp.net/attachments/864022028952010763/1121660692450250782/images.jpg?width=416&height=188",""));
        homeCatListItem5.add(new Categoryitem(2,"Players","https://media.discordapp.net/attachments/864022028952010763/1121660692731265074/d3d26140233701.5606d3383fa4c.jpg?width=1200&height=600",""));
        homeCatListItem5.add(new Categoryitem(3,"Kahaani","https://media.discordapp.net/attachments/864022028952010763/1121660693020680224/b307d127256085.560502e8b209e.jpg?width=1200&height=600",""));
        homeCatListItem5.add(new Categoryitem(4,"Tiger Zinda hai","https://media.discordapp.net/attachments/864022028952010763/1121660693440106536/Horizontal-poster-of-Tiger-Zinda-Hai.jpg?width=993&height=662",""));
        homeCatListItem5.add(new Categoryitem(5,"URI","https://media.discordapp.net/attachments/864022028952010763/1121660693805006919/706b9474134343.5c239806af449.jpg?width=1200&height=600",""));


        allCategoryList= new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Next TV and Movies",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Movies in Hindi",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Kids and Family Movie Shows",homeCatListItem3));
        allCategoryList.add(new AllCategory(5,"Popular shows",homeCatListItem5));
        allCategoryList.add(new AllCategory(4,"Amazon Original Shows",homeCatListItem4));


        setMainRecycler(allCategoryList);

    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);

        tabLayoutMediator = new TabLayoutMediator(tabLayout, bannerMoviesViewPager,
                (tab, position) -> {
                    // Set the tab text or any customization based on the position
                    // For example, if you have a List<String> of tab titles, you can use:
                    // tab.setText(tabTitles.get(position));
                });
        tabLayoutMediator.attach();

        Timer slideTimer = new Timer();
        slideTimer.scheduleAtFixedRate(new AutoSlider(), 5000, 7000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tabLayoutMediator.detach(); // Detach the TabLayoutMediator in onDestroy
    }

    class AutoSlider extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(() -> {
                if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1) {
                    bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                } else {
                    bannerMoviesViewPager.setCurrentItem(0);
                }
            });
        }
    }



    public void setMainRecycler(List<AllCategory> allCategoryList){
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter=new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }
    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }


}
