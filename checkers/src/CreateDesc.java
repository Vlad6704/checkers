import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateDesc extends JPanel implements Runnable {

    public CreateDesc() {


        inf1 = new II_muve_inf();
        inf2 = new II_muve_inf();
        inf3 = new II_muve_inf();
        inf4 = new II_muve_inf();
        mul = new multiplication();






        save_muve(inf1);


        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();



                //System.out.println(Arrays.deepToString(arCapKick));
               // System.out.println(x);

              // System.out.println(y);


                if(y< 50){

                    load_muve(inf1);


                }
                if(y>50 && x <50) {
                    save_muve(inf1);
                }


                if((x >400)&&(x<450)){

                        II();

                }


                if( x > 450) {

                   // II_2_start();
                }

                if(x<371) {
                    if (howManyClick == 0) {
                        whoMuve = whoName(toBoxCoordinateX(x), toBoxCoordinateY(y));

                        if (whoMuve.getColor() == next_muve) {
                            if (mast_two_kick) {
                                if (whoMuve == arN_Obj[two_kick_Numb]) {
                                    if (success_choose) {
                                        howManyClick = 1;
                                        success_choose = false;

                                    }
                                }
                            }
                            if (mast_kick && !mast_two_kick) {

                                for (int es = 0; es < who_mast_kick.length; es++) {
                                    if (whoMuve == arN_Obj[who_mast_kick[es]]) {
                                        if (success_choose) {
                                            howManyClick = 1;
                                            success_choose = false;
                                        }
                                    }
                                }

                            } else if (!mast_two_kick) {

                                if (success_choose) {
                                    howManyClick = 1;
                                    success_choose = false;
                                }
                            }
                        }
                    } else {
                        if (mast_kick) {
                            for (int se = 0; se < arCapKick.length; se++) {
                                for (int sa = 0; sa < 4; sa++) {
                                    for (int sy = 0; sy < 15; sy++) {
                                        if ((arCapKick[se][sa][sy] <= x) && (arCapKick[se][sa][sy] + 40 >= x) && (arCapKick[se][sa][sy + 1] <= y) && (arCapKick[se][sa][sy + 1] + 40 >= y)) {
                                            if (!mast_two_kick) two_kick_Numb = se;
                                           // was_kick = true;

                                            muve_AND_kick(x, y);
                                        }
                                    }

                                }
                            }
                        } else {

                            muve_AND_kick(x, y);
                        }
                    }


                    chekh_capabilitie_kick();

                    if (success_muve) {
                        if (next_muve == 'w') next_muve = 'b';
                        else next_muve = 'w';


                    }


                    create_arr_kick();


                    if (mast_kick && was_kick) {

                        for (int yr = 0; yr < 4; yr++) {
                            for (int ya = 0; ya < 15; ya++) {
                                if (arCapKick[two_kick_Numb][yr][ya] != 0) {
                                    mast_two_kick = true;
                                    pr("mast_two_kick");
                                    pr(mast_two_kick);
                                }
                            }
                        }
                    }


                    if (success_muve && mast_two_kick) {
                        if (next_muve == 'w') next_muve = 'b';
                        else next_muve = 'w';
                        success_muve = false;

                    } else success_muve = false;


                    pr(howManyClick);
                    pr(next_muve);

                    repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });






        CreateColorAr();


    }

    private   Thread t;
    private II_muve_inf inf1;
    private II_muve_inf inf2;
    private II_muve_inf inf3;
    private II_muve_inf inf4;
    private multiplication mul;
    private   int ese=1;
    private int II_e=0;
    private int II_ee=0;
    private int ewd=0;
    private int II_step_by_step_LOOP_FOR=0;
    private boolean mast_kick=false;
    private int size_box = 40;
    private int padding = 50;
    private int char_padding = 17;
    private int number_padding = 22;
    private Graphics gr;
    private W_checkers  A1 = new W_checkers(1, 'A');
    private W_checkers  C1 = new W_checkers(1, 'C');
    private W_checkers  E1 = new W_checkers(1, 'E');
    private W_checkers  G1 = new W_checkers(1, 'G');
    private W_checkers  B2 = new W_checkers(2, 'B');
    private W_checkers  D2 = new W_checkers(2, 'D');
    private W_checkers  F2 = new W_checkers(2, 'F');
    private W_checkers  H2 = new W_checkers(2, 'H');

    private W_checkers A3 = new W_checkers(3, 'Z');
    private W_checkers C3 = new W_checkers(3, 'Z');
    private W_checkers E3 = new W_checkers(3, 'Z');
    private W_checkers G3 = new W_checkers(3, 'Z');

    private B_Checkers  B6 = new B_Checkers(6, 'Z');
    private B_Checkers  D6 = new B_Checkers(6, 'Z');
    private B_Checkers F6 = new B_Checkers(6,  'Z');
    private B_Checkers H6 = new B_Checkers(6,  'Z');


    private B_Checkers A7 = new B_Checkers(7, 'Z');
    private B_Checkers C7 = new B_Checkers(7, 'Z');
    private B_Checkers E7 = new B_Checkers(7, 'Z');
    private B_Checkers G7 = new B_Checkers(7, 'Z');
    private B_Checkers B8 = new B_Checkers(8, 'B');
    private B_Checkers D8 = new B_Checkers(8, 'D');
    private B_Checkers F8 = new B_Checkers(8, 'F');
    private B_Checkers H8 = new B_Checkers(8, 'H');

    private King_B_Checkers K_B1 = new King_B_Checkers(0, 'Z');
    private King_B_Checkers K_B2 = new King_B_Checkers(0, 'Z');
    private King_B_Checkers K_B3 = new King_B_Checkers(0, 'Z');
    private King_B_Checkers K_B4 = new King_B_Checkers(0, 'Z');
    private King_B_Checkers K_B5 = new King_B_Checkers(0, 'Z');


    private King_W_Checkers K_W1 = new King_W_Checkers(0, 'Z');
    private King_W_Checkers K_W2 = new King_W_Checkers(0, 'Z');
    private King_W_Checkers K_W3 = new King_W_Checkers(0, 'Z');
    private King_W_Checkers K_W4 = new King_W_Checkers(0, 'Z');
    private King_W_Checkers K_W5 = new King_W_Checkers(0, 'Z');


    Checkers [] arN_Obj =  {

            A1, C1, E1, G1, B2, D2, F2, H2,

            A3,C3,E3,G3,

            B6, D6, F6, H6,

            A7, C7, E7, G7, B8, D8, F8, H8,

            K_B1, K_B2, K_B3, K_B4, K_B5,

            K_W1, K_W2, K_W3, K_W4, K_W5

    };
    public String [] arCoordinate = new String [arN_Obj.length];
    public char[] arColor = new char[arN_Obj.length];
    public int[][][] arCapKick= new int[34][4][15];
    private int [] who_mast_kick;
    public int howManyClick = 0;
    public int howManyClickII = 0;
    public Checkers whoMuve;
    public String whereMuve;
    public int del =-1;
    public int posKing;
    private int howManyB_King =0;
    private int howManyW_King =0;
    private int clock_one=9;
    private int clock_two=13;
    public boolean success_choose = false;
    public boolean success_muve = false;
    public boolean success_del = false;
    public int two_kick_Numb=-1;
    public  char next_muve = 'w';
    private boolean was_kick =false;
    public boolean mast_two_kick=false;
    private boolean II_step_by_step_was_muve=false;
    private boolean II_save_first_muve = false;
    private boolean II_correct_chuse=false;
    private boolean II_next_level_1 = true;
    private boolean II_next_level_2 = true;
    private boolean II_next_level_3 = true;
    public int[][] arr_II_muvs = new int [50000][11];

    private ArrayList<int[]> arr_find_muve = new ArrayList<int[]>();

    int two_kick_loop_eror =0;

    private int a [][] = new int[arN_Obj.length][2];
    private int f [][] = new int[1][2];
    private int b [][][] = {a,f};
    private int save_II_arr [][][][] = {b,b,b};
    public int II_2_quantity_clone =0;
    boolean to = true;
    private char [] arAllBox_X = {
            'A','C','E','G',
            'B','D','F','H',
            'A','C','E','G',
            'B','D','F','H',
            'A','C','E','G',
            'B','D','F','H',
            'A','C','E','G',
            'B','D','F','H'
    };
    private int [] arAllBox_Y = {
            1,3,5,7,
            2,4,6,8,
            1,3,5,7,
            2,4,6,8,
            1,3,5,7,
            2,4,6,8,
            1,3,5,7,
            2,4,6,8,
    };
    private int [] arCoordAllBox_X = {
            72,143,228,309,
            114,181,270,362,
            72,143,228,309,
            114,181,270,362,
            72,143,228,309,
            114,181,270,362,
            72,143,228,309,
            114,181,270,362,
    };
    private int []  arCoordAllBox_Y = {
            344,344,344,344,
            305,305,305,305,
            269,269,269,269,
            232,232,232,232,
            190,190,190,190,
            154,154,154,154,
            111,111,111,111,
            64,64,64,64,
    };





    //public  Checkers [] arName =  {A1, C1, E1, G1, B2, D2, F2, H2};


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gr = g;
        DrawDesc();
        DrawCircleW(A1.getPositionY(), A1.getPositionX());
        DrawCircleW(C1.getPositionY(), C1.getPositionX());
        DrawCircleW(E1.getPositionY(), E1.getPositionX());
        DrawCircleW(G1.getPositionY(), G1.getPositionX());
        DrawCircleW(B2.getPositionY(), B2.getPositionX());
        DrawCircleW(D2.getPositionY(), D2.getPositionX());
        DrawCircleW(F2.getPositionY(), F2.getPositionX());
        DrawCircleW(H2.getPositionY(), H2.getPositionX());
        DrawCircleW(A3.getPositionY(), A3.getPositionX());
        DrawCircleW(C3.getPositionY(), C3.getPositionX());
        DrawCircleW(E3.getPositionY(), E3.getPositionX());
        DrawCircleW(G3.getPositionY(), G3.getPositionX());




        DrawCircleB(B6.getPositionY(), B6.getPositionX());
        DrawCircleB(D6.getPositionY(), D6.getPositionX());
        DrawCircleB(F6.getPositionY(), F6.getPositionX());
        DrawCircleB(H6.getPositionY(), H6.getPositionX());
        DrawCircleB(A7.getPositionY(), A7.getPositionX());
        DrawCircleB(C7.getPositionY(), C7.getPositionX());
        DrawCircleB(E7.getPositionY(), E7.getPositionX());
        DrawCircleB(G7.getPositionY(), G7.getPositionX());
        DrawCircleB(B8.getPositionY(), B8.getPositionX());
        DrawCircleB(D8.getPositionY(), D8.getPositionX());
        DrawCircleB(F8.getPositionY(), F8.getPositionX());
        DrawCircleB(H8.getPositionY(), H8.getPositionX());


        DrawCircleK_B(K_B1.getPositionY(), K_B1.getPositionX());
        DrawCircleK_B(K_B2.getPositionY(), K_B2.getPositionX());
        DrawCircleK_B(K_B3.getPositionY(), K_B3.getPositionX());
        DrawCircleK_B(K_B4.getPositionY(), K_B4.getPositionX());
        DrawCircleK_B(K_B5.getPositionY(), K_B5.getPositionX());


        DrawCircleK_W(K_W1.getPositionY(), K_W1.getPositionX());
        DrawCircleK_W(K_W2.getPositionY(), K_W2.getPositionX());
        DrawCircleK_W(K_W3.getPositionY(), K_W3.getPositionX());
        DrawCircleK_W(K_W4.getPositionY(), K_W4.getPositionX());
        DrawCircleK_W(K_W5.getPositionY(), K_W5.getPositionX());



    }




    private void create_arr_kick(){
        mast_kick = false;
        int lenght_ar=0;
        for(int ee=0; ee<34;ee++){
            for(int r=0; r<4;r++){
                for(int w =0; w<15;w++){
                    if(arCapKick[ee][r][w]!=0){
                        lenght_ar++;
                        pr(arCapKick[ee][r][w]);

                    }
                }

            }
        }
        who_mast_kick = new int[lenght_ar/2];
        int yth=0;
        int ggty=0;
        for(int ee=0; ee<34;ee++){
            for(int r=0; r<4;r++){
                for(int w =0; w<15;w++){
                    if(arCapKick[ee][r][w]!=0){
                        if(ggty==0){
                            who_mast_kick[yth]=ee;
                            if(arN_Obj[ee].getColor()==next_muve) {
                               pr("must_kick : true");
                                mast_kick = true;
                            }
                            yth++;
                            ggty=1;
                        }else {
                            ggty=0;
                        }


                    }
                }

            }
        }
    }


    
    

    private void muve_AND_kick(int x, int y){
        howManyClick = 0;
        //del = whoMuve.Muve(toBoxCoordinateX(x), toBoxCoordinateY(y));
       if(mast_two_kick) {
          
           del = whoMuve.Muve(toBoxCoordinateX(x), toBoxCoordinateY(y));
           mast_two_kick = false;


       }else {
          
            del = whoMuve.Muve(toBoxCoordinateX(x),toBoxCoordinateY(y));
            if((del !=200)&&(del!=-1)){

                was_kick = true;
                pr("was_kick : true");
            }
       }

        //System.out.println(del);
        if (del >= 0 && del < 200) {
            DeleteCheck(del);
            success_muve = true;
            II_step_by_step_was_muve=true;

            //success_del = true;
            del = -1;

        }
        if (del == 200) {
            success_muve = true;
            II_step_by_step_was_muve=true;
            del = -1;
            was_kick=false;

        }


        WriteAr();
        posKing = whoMuve.getPosKing(toBoxCoordinateX(x), toBoxCoordinateY(y));
        if (posKing > 0){

            AppearKing(posKing);
        }
    }



    //for II
    private void muve_AND_kick(int x, int y, int level,int pos_lev_1, int pos_lev_2, int pos_lev_3, int pos_lev_4, int global_pos ,int old_x, int old_y){
        howManyClick = 0;
        //del = whoMuve.Muve(toBoxCoordinateX(x), toBoxCoordinateY(y));
        if(mast_two_kick) {

            del = whoMuve.Muve(toBoxCoordinateX(x), toBoxCoordinateY(y));
            mast_two_kick = false;


        }else {

            del = whoMuve.Muve(toBoxCoordinateX(x),toBoxCoordinateY(y));
            if((del !=200)&&(del!=-1)){

                was_kick = true;
                pr("was_kick : true");
            }
        }

        //System.out.println(del);
        if (del >= 0 && del < 200) {
            DeleteCheck(del);
            success_muve = true;
            II_step_by_step_was_muve=true;
            System.out.println("del " + level);
            arr_II_muvs_write(level, pos_lev_1,  pos_lev_2,  pos_lev_3,  pos_lev_4,global_pos,old_x,old_y,x,y,1);
            //success_del = true;
            del = -1;

        }
        if (del == 200) {
            success_muve = true;
            II_step_by_step_was_muve=true;
            del = -1;
            was_kick=false;
            System.out.println("muve " + level);
            arr_II_muvs_write(level, pos_lev_1,  pos_lev_2,  pos_lev_3,  pos_lev_4,global_pos,old_x,old_y,x,y,0);
        }


        WriteAr();
        posKing = whoMuve.getPosKing(toBoxCoordinateX(x), toBoxCoordinateY(y));
        if (posKing > 0){

            AppearKing(posKing);
        }
    }


    public void arr_II_muvs_write(int level, int pos_lev_1, int pos_lev_2, int pos_lev_3, int pos_lev_4, int global_pos , int old_x,int old_y, int x, int y , int result){
        arr_II_muvs[global_pos][0] = level;
        arr_II_muvs[global_pos][1] = pos_lev_1;
        arr_II_muvs[global_pos][2] = pos_lev_2;
        arr_II_muvs[global_pos][3] = pos_lev_3;
        arr_II_muvs[global_pos][4] = pos_lev_4;
        arr_II_muvs[global_pos][5] = old_x;
        arr_II_muvs[global_pos][6] = old_y;
        arr_II_muvs[global_pos][7] = x;
        arr_II_muvs[global_pos][8] = y;
        if(arr_II_muvs[global_pos][9] > 0) arr_II_muvs[global_pos][9] = arr_II_muvs[global_pos][9] + result;
        else arr_II_muvs[global_pos][9] = result;
    }


    private void II_find_muve(){

     System.out.println(Arrays.toString(II_f_m_kick_lev_1()));
     System.out.println(Arrays.toString(II_f_m_kick_lev_2()));
     System.out.println(Arrays.toString(II_f_m_kick_lev_3()));
     System.out.println(Arrays.toString(II_f_m_kick_lev_4()));



     //System.out.println(Arrays.toString(arr_find_muve.get(0)));
    }



    private int[] II_f_m_kick_lev_1(){
        int lev_1_quantity_branch = II_how_many_pos_in_level_1();
        int arr_l_1[] = new int[lev_1_quantity_branch];

    for(int quan =1; quan <= lev_1_quantity_branch; quan++) {
        for (int ii = 0; ii < arr_II_muvs.length; ii++) {
            if (arr_II_muvs[ii][1] == quan && arr_II_muvs[ii][0] == 1 && arr_II_muvs[ii][9] > 0) arr_l_1[quan - 1] =arr_II_muvs[ii][9];

        }
    }

            return arr_l_1;
    }

    private int[] II_f_m_kick_lev_2(){
        int lev_1_quantity_branch = II_how_many_pos_in_level_1();
        int arr_l_1[] = new int[lev_1_quantity_branch];


        int max_kick =0;
        int count =0;
        for (int enum_lev_1 = 1; enum_lev_1 <= II_how_many_pos_in_level_1();enum_lev_1 ++) {
            for (int i = 0; i < arr_II_muvs.length; i++) {
                if (arr_II_muvs[i][1] == enum_lev_1 && arr_II_muvs[i][0] == 2 && arr_II_muvs[i][9] > 0) {
                    if(arr_II_muvs[i][9] > max_kick) max_kick = arr_II_muvs[i][9];

                    count++;
                }
            }
            if (count == II_how_many_pos_in_level_3(enum_lev_1) && count >0) arr_l_1[enum_lev_1] = max_kick ;
            count =0;
        }

        return arr_l_1;
    }

    private int[] II_f_m_kick_lev_3(){
        int lev_1_quantity_branch = II_how_many_pos_in_level_1();
        int arr_l_1[] = new int[lev_1_quantity_branch];

        int max_kick =0;
        int count =0;
        for (int enum_lev_1 = 1; enum_lev_1 <= II_how_many_pos_in_level_1();enum_lev_1 ++) {
            for (int i = 0; i < arr_II_muvs.length; i++) {
                if (arr_II_muvs[i][1] == enum_lev_1 && arr_II_muvs[i][0] == 3 && arr_II_muvs[i][9] > 0) {
                    if(arr_II_muvs[i][9] > max_kick) max_kick = arr_II_muvs[i][9];

                    count++;
                }
            }
            if (count == II_how_many_pos_in_level_3(enum_lev_1) && count >0) arr_l_1[enum_lev_1] = max_kick ;
            max_kick = 0;
            count =0;
        }

        return arr_l_1;
    }

    private int[] II_f_m_kick_lev_4(){
        int lev_1_quantity_branch = II_how_many_pos_in_level_1();
        int arr_l_1[] = new int[lev_1_quantity_branch];


        int max_kick =0;
        int count =0;
        int count2 =0;
        for (int enum_lev_1 = 1; enum_lev_1 <= II_how_many_pos_in_level_1();enum_lev_1 ++) {
            for(int enum_lev_2 =1; enum_lev_2 <= II_how_many_pos_in_level_2(enum_lev_1); enum_lev_2++) {
                for (int i = 0; i < arr_II_muvs.length; i++) {
                    if (arr_II_muvs[i][1] == enum_lev_1 && arr_II_muvs[i][2] == enum_lev_2 && arr_II_muvs[i][0] == 4 && arr_II_muvs[i][9] > 0) {
                        if (arr_II_muvs[i][9] > max_kick) max_kick = arr_II_muvs[i][9];

                        count2++;
                        if(arr_II_muvs[i][1] == enum_lev_1)count++;
                    }
                }
            }
            if (count == II_how_many_pos_in_level_1() && count >0){
                if(count2 == II_how_many_pos_in_level_3(enum_lev_1)) arr_l_1[enum_lev_1] = max_kick ;
            }
            max_kick = 0;
            count =0;
        }

        return arr_l_1;
    }



    private int II_how_many_pos_in_level_1(){
        int count=0;
        for(int i =0; i<arr_II_muvs.length;i++){
            if(arr_II_muvs[i][0] == 1)count++;
        }
        return count;
    }

    private int II_how_many_pos_in_level_2(int level_1){
        int count=0;
        for(int i =0; i<arr_II_muvs.length;i++){
            if(arr_II_muvs[i][0] == 2 && arr_II_muvs[i][1] == level_1)count++;
        }
        return count;
    }

    private int II_how_many_pos_in_level_3(int level_1,int level_2){
        int count=0;
        for(int i =0; i<arr_II_muvs.length;i++){
            if(arr_II_muvs[i][1] == level_1 && arr_II_muvs[i][2] == level_2 && arr_II_muvs[i][0] == 3)count++;
        }
        return count;
    }

    private int II_how_many_pos_in_level_3(int level_1){
        int count=0;
        for(int i =0; i<arr_II_muvs.length;i++){
            if(arr_II_muvs[i][1] == level_1 && arr_II_muvs[i][0] == 3)count++;
        }
        return count;
    }

    private int II_how_many_pos_in_level_4(int level_1,int level_2, int level_3){
        int count=0;
        for(int i =0; i<arr_II_muvs.length;i++){
            if(arr_II_muvs[i][1] == level_1 && arr_II_muvs[i][2] == level_2 && arr_II_muvs[i][3] == level_3 && arr_II_muvs[i][0] == 4)count++;
        }
        return count;
    }


    private void quantity_clone(int quantity) {


    for (int i = 0; i < quantity; i++) {
        mul.arr_clone_II_muve_inf1[i] = inf_clone(inf1);
    }
    for (int i = 0; i < quantity; i++) {
        mul.arr_clone_II_muve_inf2[i] = inf_clone(inf2);
    }
    for (int i = 0; i < quantity; i++) {
        mul.arr_clone_II_muve_inf3[i] = inf_clone(inf3);
    }
    for (int i = 0; i < quantity; i++) {
        mul.arr_clone_II_muve_inf4[i] = inf_clone(inf4);
    }

    for(int i =0; i<quantity; i++){
        for(int ii =0; ii<arN_Obj.length;ii++){
            mul.arr_clone_Checkers[i][ii] = ChOb_clone(ii);
        }
    }

}

    public II_muve_inf inf_clone( II_muve_inf inf ){
    try{

        return inf.clone();


    }
    catch(CloneNotSupportedException ex){

        System.out.println("Cloneable not implemented");
    }finally {
        return inf;
    }

}

    public Checkers ChOb_clone( int i){
        try{


           return arN_Obj[i].clone();



        }
        catch(CloneNotSupportedException ex){

            System.out.println("Cloneable not implemented");
        }finally {
            return arN_Obj[0];
        }

    }


    public int toBoxCoordinateY(int px){
        return (8-(px-padding)/size_box);
    }
    public char toBoxCoordinateX(int px){
        int intx = (px-padding)/size_box+65;
        char charx = (char) intx;
        return charx;
    }


    public void invert_next_muve(){
        if(next_muve =='w')next_muve = 'b';
        else next_muve ='w';
    }



    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());


            //II_2_Thr(mul.arr_clone_II_muve_inf1[II_2_quantity_clone],mul.arr_clone_II_muve_inf2[II_2_quantity_clone],mul.arr_clone_II_muve_inf3[II_2_quantity_clone],mul.arr_clone_II_muve_inf4[II_2_quantity_clone],mul.arr_clone_Checkers[II_2_quantity_clone] );


        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }


//    public void II_2_Thr(II_muve_inf inf_c1 , II_muve_inf inf_c2, II_muve_inf inf_c3 ,II_muve_inf inf_c4, Checkers[] arN_Obj_c){
//        System.out.println("II");
//
//        boolean II_2_next_level_1 = true;
//        boolean II_2_next_level_2 = true;
//        boolean II_2_next_level_3 = true;
//
//
//        boolean loop = true;
//        float counter = 0;
//        long startTime = System.currentTimeMillis();
//        while(loop) {
//
//
//
//
//            if (II_2_next_level_1) {
//                load_muve(inf_c1);
//                if (II_proc(inf_c1)) loop = false;
//                save_muve(inf_c2);
//                II_2_next_level_1 = false;
//                pr("muve 1111");
//                System.out.println("111111111111111111");
//                counter++;
//            }
//            if (II_2_next_level_2) {
//                load_muve(inf_c2);
//                if (II_proc(inf_c2)) {
//
//                    II_2_next_level_1 = true;
//                } else {
//
//                    save_muve(inf_c3);
//                }
//                II_2_next_level_2 = false;
//                pr("muve 22222");
//                //System.out.println("2222222222222");
//                counter++;
//            }
//            if (II_2_next_level_3) {
//                load_muve(inf_c3);
//                if (II_proc(inf_c3)) {
//
//                    II_2_next_level_2 = true;
//                } else {
//
//                    save_muve(inf_c4);
//                }
//                II_2_next_level_3 = false;
//                pr("muve 22222");
//                // System.out.println("33333");
//                counter++;
//            }
//            load_muve(inf_c4);
//            if (II_proc(inf_c4)) {
//                II_2_next_level_3 = true;
//            }
//            pr("muve 3333");
//            //System.out.println("4");
//            counter++;
//
//        }  float timeSpent = System.currentTimeMillis() - startTime; System.out.print("программа выполнялась " + timeSpent/1000 + " секунд       ");  System.out.print("counter : " + counter); System.out.println("    шагов в секунду : " + counter/(timeSpent/1000) + "       ");
//
//    }


    public void II_2_start(){
        quantity_clone(5);

        for (int i=0; i<4; i++) {
            new Thread(this, "th"+i).start();
            II_2_quantity_clone++;
        }

    }

    public void II() {
        System.out.println("II");


        /*
        arr_II_muve
        0 level
        1 pos_lev_1
        2 pos_lev_2
        3 pos_lev_3
        4 pos_lev_4
        5 whence  x  откуда
        6 whence  y  откуда
        7 whither x куда
        8 whither y куда
        9 result

        global_pos = pos_in_arr


         */


    int II_1_lev = 0;
    int II_2_lev = 0;
    int II_3_lev = 0;
    int II_4_lev = 0;
    boolean loop = true;
    int counter = 0;

        long startTime = System.currentTimeMillis();
    while(loop) {



        if (II_next_level_1) {
            II_1_lev++;
            II_2_lev = 0;
            II_next_level_2 = true;
            II_next_level_3 = true;

            load_muve(inf1);
            if (II_proc(inf1, 1, II_1_lev,-1,-1,-1, counter)) loop = false;
            counter++;
            save_muve(inf2);
            II_next_level_1 = false;
            pr("muve 1111");
            System.out.println("111111111111111111");


        }
        if (II_next_level_2) {

            II_2_lev++;
            II_3_lev = 0;
            load_muve(inf2);
            if (II_proc(inf2, 2,  II_1_lev,II_2_lev,-1,-1, counter)) {

                II_next_level_1 = true;
            } else {

                save_muve(inf3);
            }
            counter++;
            II_next_level_2 = false;
            pr("muve 22222");
            //System.out.println("2222222222222");


        }
        if (II_next_level_3) {
            II_4_lev = 0;
            II_3_lev++;

            load_muve(inf3);
            if (II_proc(inf3, 3, II_1_lev,II_2_lev,II_3_lev,-1, counter)) {

                II_next_level_2 = true;
            } else {

                save_muve(inf4);
            }
            counter++;
            II_next_level_3 = false;
            pr("muve 22222");
           // System.out.println("33333");


        }
        load_muve(inf4);
        II_4_lev++;


        if (II_proc(inf4 , 4, II_1_lev,II_2_lev,II_3_lev,II_4_lev, counter)) {
            II_next_level_3 = true;
        }
        counter++;
        pr("muve 3333");
        //System.out.println("4");


        System.out.println(counter);
   }  float timeSpent = System.currentTimeMillis() - startTime; System.out.print("программа выполнялась " + timeSpent/1000 + " секунд       ");  System.out.print("counter : " + counter); System.out.println("    шагов в секунду : " + counter/(timeSpent/1000) + "       ");

    to = false;






        for(int i =0; i<10000; i++){
//            if(arr_II_muvs[i][0] == 1) System.out.println(Arrays.toString(arr_II_muvs[i]));
//            if(arr_II_muvs[i][0] == 2) System.out.print(Arrays.toString(arr_II_muvs[i]));
//            if(arr_II_muvs[i][0] == 3) System.out.println(Arrays.toString(arr_II_muvs[i]));
            System.out.print(i + " "); System.out.println(Arrays.toString(arr_II_muvs[i]));

        }




        System.out.println( "II_how_many_pos_in_level "+ II_how_many_pos_in_level_1());
        System.out.println( "II_how_many_pos_in_leve2 "+ II_how_many_pos_in_level_2(2));
        System.out.println( "II_how_many_pos_in_leve3 "+ II_how_many_pos_in_level_3(1,3));
        System.out.println( "II_how_many_pos_in_leve4 "+ II_how_many_pos_in_level_4(2,3,3));


        II_find_muve();

    }
    public boolean II_proc(II_muve_inf inf, int level, int pos_lev_1, int pos_lev_2, int pos_lev_3, int pos_lev_4, int global_pos){
        II_step_by_step_was_muve=false;
        for(; II_step_by_step_LOOP_FOR<1024; II_step_by_step_LOOP_FOR++){
            if(II_step_by_step_was_muve && !mast_two_kick) {

                II_was_muve(inf);
                break;
            }

            II_next_muve_step_by_step(level,pos_lev_1, pos_lev_2,pos_lev_3,pos_lev_4, global_pos);

            if(mast_two_kick){

               // invert_next_muve();


            }


        }

       if(II_step_by_step_LOOP_FOR == 1024 && !mast_two_kick) {
           System.out.println(" over 1024");
           save_II_loop_over(inf);
           return true;
       }


        if(II_step_by_step_LOOP_FOR == 1024 && two_kick_loop_eror>3) {
            two_kick_loop_eror = 0;
            System.out.println(" over 1024");
            save_II_loop_over(inf);
            return true;
        }

        if(II_step_by_step_LOOP_FOR == 1024 && mast_two_kick && (two_kick_loop_eror<4)) {
            System.out.println(" over 1024");
            II_step_by_step_LOOP_FOR = 0;
            II_e =0;
            II_ee = 0;
            two_kick_loop_eror ++;
            System.out.println("ffffffffffffffffffffffffffff" + next_muve);
            II_proc( inf,  level,pos_lev_1,pos_lev_2,pos_lev_3,pos_lev_4,global_pos);

        }


        return false;
    }


    private void II_was_muve( II_muve_inf inf){
        II_step_by_step_was_muve=false;
        pr("bbbbbbbbbbbbbbbbbbbbbbbbbb was muve");


        save_II_var(inf);
        pr("II_step_by_step_LOOP_FOR number try " + II_step_by_step_LOOP_FOR);
    }





    private void save_II_loop_over(II_muve_inf inf){
        inf.setII_step_by_step_LOOP_FOR(0);
        inf.setII_e(0);
        inf.setII_ee(0);
    }

    private void save_II_var(II_muve_inf inf){



        inf.setII_step_by_step_LOOP_FOR(II_step_by_step_LOOP_FOR);
        inf.setII_e(II_e);
        inf.setII_ee(II_ee);
    }

    private void save_muve(II_muve_inf inf){


            inf.setAr_Ch_x(arN_Obj);
            inf.setAr_Ch_y(arN_Obj);
//            inf.setII_e(II_e);
//            inf.setII_ee(II_ee);
            inf.setNext_muve(next_muve);
            inf.setMast_two_kick(mast_two_kick);
            inf.setTwo_kick_Numb(two_kick_Numb);
            inf.setSuccess_choose(success_choose);
            inf.setII_correct_chuse(II_correct_chuse);
            inf.setMast_kick(mast_kick);
            inf.setII_step_by_step_was_muve(II_step_by_step_was_muve);
            inf.setWas_kick(was_kick);
            inf.setSuccess_muve(success_muve);
            inf.setDead(arN_Obj);
//            inf.setII_step_by_step_LOOP_FOR(II_step_by_step_LOOP_FOR);

            pr("save");

    }


    private void load_muve(II_muve_inf inf) {

        for (int sa = 0; sa < arN_Obj.length; sa++) {
            arN_Obj[sa].setPositionX(inf.getAr_Ch_x()[sa]);
            arN_Obj[sa].setPositionY(inf.getAr_Ch_y()[sa]);
        }

        II_e = inf.getII_e();
        II_ee = inf.getII_ee();
        next_muve = inf.getNext_muve();
        mast_two_kick = inf.getMast_two_kick();
        two_kick_Numb = inf.getTwo_kick_Numb();
        success_choose = inf.getSuccess_choose();
        II_correct_chuse = inf.getII_correct_chuse();
        mast_kick = inf.getMast_kick();
        II_step_by_step_was_muve = inf.getII_step_by_step_was_muve();
        was_kick = inf.getWas_kick();
        success_muve = inf.getSuccess_muve();
        II_step_by_step_LOOP_FOR = inf.get_next_II_step_by_step_LOOP_FOR();

        for (int sa = 0; sa < arN_Obj.length; sa++) {
            arN_Obj[sa].setDead(inf.getDead()[sa]);
          }





        pr("load");

    }



    private void II_next_muve_step_by_step(int level,int pos_lev_1, int pos_lev_2, int pos_lev_3, int pos_lev_4, int global_pos){



                    II_chuse_pown(arCoordAllBox_X[II_e],arCoordAllBox_Y[II_e]);
                    II_muve(arCoordAllBox_X[II_ee],arCoordAllBox_Y[II_ee] , level,pos_lev_1, pos_lev_2,pos_lev_3,pos_lev_4, global_pos,arCoordAllBox_X[II_e], arCoordAllBox_Y[II_e]);
                    II_post_muve();




                    II_ee++;
                    if(II_ee==31){
                        II_ee=0;
                        II_e++;
                        if(II_e==32){
                            II_e=0;
                        }
                    }

//                    pr("II_E");
//                    pr(II_e);
//                    pr("II_EE");
//                    pr(II_ee);
//                    ewd++;
//                    pr("all_try");
//                    pr(ewd);

    }

/*
    public void II(){
        for(int i=0; i<arN_Obj.length; i++){
            for(int e =0; e<arN_Obj.length; e++){
                del = arN_Obj[i].Muve(arAllBox_X[e],arAllBox_Y[e]);
                if(del>=0)DeleteCheck(del);
                WriteAr();
                posKing= arN_Obj[i].getPosKing(arAllBox_X[e],arAllBox_Y[e]);
                if(posKing>0)AppearKing(posKing);
            }
        }
        System.out.println("Compleat");
    }

*/
    public void CreateColorAr(){
        for(int i=0; i<arN_Obj.length; i++){
            arColor[i]=arN_Obj[i].getColor();


        }
        Checkers.setArStatColor(arColor);

    }


    private int II_chuse_pown(int x, int y){
        whoMuve = whoName(toBoxCoordinateX(x), toBoxCoordinateY(y));

        if(whoMuve.getColor()==next_muve) {
           // pr("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            if (mast_two_kick) {
                if (whoMuve == arN_Obj[two_kick_Numb]) {
                    if (success_choose) {
                        II_correct_chuse = true;
                        success_choose = false;
                        return 1;

                    }
                }
            }
            if (mast_kick&&!mast_two_kick) {

                for (int es = 0; es < who_mast_kick.length; es++) {
                    if (whoMuve == arN_Obj[who_mast_kick[es]]) {
                        if (success_choose) {
                            II_correct_chuse = true;
                            success_choose = false;
                           return 1;
                        }
                    }
                }

            } else if(!mast_two_kick) {

                if (success_choose) {
                    II_correct_chuse = true;
                    success_choose = false;
                    return 1;
                }
            }
        }

        return 5;
    }



    private int II_muve(int x, int y , int level,int pos_lev_1, int pos_lev_2, int pos_lev_3, int pos_lev_4, int global_pos , int old_x, int old_y){
        if(II_correct_chuse) {
            II_correct_chuse=false;
            if (mast_kick) {
                for (int se = 0; se < arCapKick.length; se++) {
                    for (int sa = 0; sa < 4; sa++) {
                        for (int sy = 0; sy < 15; sy++) {
                            if ((arCapKick[se][sa][sy] <= x) && (arCapKick[se][sa][sy] + 40 >= x) && (arCapKick[se][sa][sy + 1] <= y) && (arCapKick[se][sa][sy + 1] + 40 >= y)) {
                                if (!mast_two_kick) two_kick_Numb = se;


                                muve_AND_kick(x, y,level,pos_lev_1,pos_lev_2,pos_lev_3,pos_lev_4,global_pos, old_x, old_y);
                            }
                        }

                    }
                }
            } else {

                muve_AND_kick(x, y,level,pos_lev_1,pos_lev_2,pos_lev_3,pos_lev_4,global_pos, old_x, old_y);
            }
        }
        return 5;
    }




    private int II_post_muve(){

        chekh_capabilitie_kick();



        if(mast_kick&&was_kick){
            for(int yr=0;yr<4;yr++) {
                for(int ya=0;ya<15;ya++){
                    if (arCapKick[two_kick_Numb][yr][ya]!=0) {
                        mast_two_kick = true;
                        //System.out.println("mast_two_kick");
                        //System.out.println(mast_two_kick);
                    }
                }
            }
        }

        if((II_step_by_step_was_muve)&&(!mast_two_kick)){

            if(next_muve =='w')next_muve = 'b';
            else next_muve ='w';


        }



        create_arr_kick();




     success_muve = false;


       // pr("next_muve");
        //pr(next_muve);
        repaint();

        return 5;
    }

    public void DeleteCheck(int i){
        arN_Obj[i].setPositionX('p');
        arN_Obj[i].setPositionY(10);
        arN_Obj[i].setDead(true);
    }


    private void chekh_capabilitie_kick(){
        for(int i=0; i<34;i++){
            arCapKick[i]=arN_Obj[i].Capabilitie_kick();
        }


        /*
        for(int w=0; w<9;w++){
            for (int ww=0; ww<4;ww++){
                for(int www=0; www<10;www++){
                    System.out.println(arCapKick[w][ww][www]);
                }
            }
        }

        */

    }

    private void AppearKing(int i){

       char x = arN_Obj[i].getPositionX();
       int y = arN_Obj[i].getPositionY();
        arN_Obj[i].setPositionX('p');
        arN_Obj[i].setPositionY(10);
        if(arN_Obj[i].getColor() == 'b'){
            arN_Obj[24+howManyB_King].setPositionX(x);
            arN_Obj[24+howManyB_King].setPositionY(y);

            if(howManyB_King<=4)howManyB_King++;

        }else{
            arN_Obj[29+howManyW_King].setPositionX(x);
            arN_Obj[29+howManyW_King].setPositionY(y);
            if(howManyW_King<=4) howManyW_King++;
        }

    }





    public void DrawDesc() {
        Graphics g = gr;
        Color dark_color = new Color(124, 88, 88);
        Color white_color = new Color(200, 200, 200);



        g.drawString("A",padding+char_padding,45);
        g.drawString("B",padding+char_padding+size_box*1,45);
        g.drawString("C",padding+char_padding+size_box*2,45);
        g.drawString("D",padding+char_padding+size_box*3,45);
        g.drawString("E",padding+char_padding+size_box*4,45);
        g.drawString("F",padding+char_padding+size_box*5,45);
        g.drawString("G",padding+char_padding+size_box*6,45);
        g.drawString("H",padding+char_padding+size_box*7,45);

//        g.drawString("A",padding+char_padding,25+size_box*9);
//        g.drawString("B",padding+char_padding+size_box*1,25+size_box*9);
//        g.drawString("C",padding+char_padding+size_box*2,25+size_box*9);
//        g.drawString("D",padding+char_padding+size_box*3,25+size_box*9);
//        g.drawString("E",padding+char_padding+size_box*4,25+size_box*9);
//        g.drawString("F",padding+char_padding+size_box*5,25+size_box*9);
//        g.drawString("G",padding+char_padding+size_box*6,25+size_box*9);
//        g.drawString("H",padding+char_padding+size_box*7,25+size_box*9);


        g.drawString("72",padding+char_padding,25+size_box*9);
        g.drawString("114",padding+char_padding+size_box*1,25+size_box*9);
        g.drawString("143",padding+char_padding+size_box*2,25+size_box*9);
        g.drawString("181",padding+char_padding+size_box*3,25+size_box*9);
        g.drawString("228",padding+char_padding+size_box*4,25+size_box*9);
        g.drawString("270",padding+char_padding+size_box*5,25+size_box*9);
        g.drawString("309",padding+char_padding+size_box*6,25+size_box*9);
        g.drawString("362",padding+char_padding+size_box*7,25+size_box*9);



        g.drawString("8",37,padding+number_padding+size_box*0);
        g.drawString("7",37,padding+number_padding+size_box*1);
        g.drawString("6",37,padding+number_padding+size_box*2);
        g.drawString("5",37,padding+number_padding+size_box*3);
        g.drawString("4",37,padding+number_padding+size_box*4);
        g.drawString("3",37,padding+number_padding+size_box*5);
        g.drawString("2",37,padding+number_padding+size_box*6);
        g.drawString("1",37,padding+number_padding+size_box*7);


//        g.drawString("8",17+size_box*9,padding+number_padding+size_box*0);
//        g.drawString("7",17+size_box*9,padding+number_padding+size_box*1);
//        g.drawString("6",17+size_box*9,padding+number_padding+size_box*2);
//        g.drawString("5",17+size_box*9,padding+number_padding+size_box*3);
//        g.drawString("4",17+size_box*9,padding+number_padding+size_box*4);
//        g.drawString("3",17+size_box*9,padding+number_padding+size_box*5);
//        g.drawString("2",17+size_box*9,padding+number_padding+size_box*6);
//        g.drawString("1",17+size_box*9,padding+number_padding+size_box*7);









        g.drawString("64",17+size_box*9,padding+number_padding+size_box*0);
        g.drawString("111",17+size_box*9,padding+number_padding+size_box*1);
        g.drawString("154",17+size_box*9,padding+number_padding+size_box*2);
        g.drawString("190",17+size_box*9,padding+number_padding+size_box*3);
        g.drawString("232",17+size_box*9,padding+number_padding+size_box*4);
        g.drawString("269",17+size_box*9,padding+number_padding+size_box*5);
        g.drawString("305",17+size_box*9,padding+number_padding+size_box*6);
        g.drawString("344",17+size_box*9,padding+number_padding+size_box*7);


        for (int i = 0; i < 8; i++) {
            if (i % 2 == 1) {
                for (int e = 0; e < 8; e++) {
                    if (e % 2 == 1) {
                        g.setColor(white_color);
                        g.fillRect(e * size_box + padding, i * size_box + padding, size_box, size_box);
                    } else {
                        g.setColor(dark_color);
                        g.fillRect(e * size_box + padding, i * size_box + padding, size_box, size_box);
                    }
                }
            } else {
                for (int u = 0; u < 8; u++) {
                    if (u % 2 == 0) {
                        g.setColor(white_color);
                        g.fillRect(u * size_box + padding, i * size_box + padding, size_box, size_box);
                    } else {
                        g.setColor(dark_color);
                        g.fillRect(u * size_box + padding, i * size_box + padding, size_box, size_box);
                    }
                }
            }
        }

    }



    public void pr(boolean b){
        System.out.println(b);
    }
    public void pr(int b){
        //System.out.println(b);
    }
    public void pr(char b){
        System.out.println(b);
    }
    public void pr(String b){

        //System.out.println(b);
    }














    public void DrawCircleB(int y, char x) {

        // System.out.println(1);
        Graphics t = gr;
        t.setColor(Color.BLACK);
        t.fillOval(getPositionX_PX(x)+2, getPositionY_PX(y)+2, size_box-5, size_box-5);
    }
    public void DrawCircleW(int y, char x) {

        // System.out.println(1);
        Graphics t = gr;
        Color white_color = new Color(189  , 250, 246);
        t.setColor(white_color);
        t.fillOval(getPositionX_PX(x)+2, getPositionY_PX(y)+2, size_box-5, size_box-5);
    }
    public void DrawCircleK_B(int y, char x) {

        // System.out.println(1);
        Graphics t = gr;
        Color white_color = new Color(129, 4, 0);
        t.setColor(white_color);
        t.fillOval(getPositionX_PX(x)+2, getPositionY_PX(y)+2, size_box-5, size_box-5);
    }
    public void DrawCircleK_W(int y, char x) {

        // System.out.println(1);
        Graphics t = gr;
        Color white_color = new Color(66, 166, 225);
        t.setColor(white_color);
        t.fillOval(getPositionX_PX(x)+2, getPositionY_PX(y)+2, size_box-5, size_box-5);
    }

    public int getPositionY_PX(int y) {
        int y_px = (8 - y) * size_box + padding;
        return y_px;

    }

    public int getPositionX_PX(char x) {

        int x_px = (int) x;
        x_px = (x_px - 65) * size_box + padding;
        return x_px;
    }



public void WriteAr(){
    for(int i=0; i<arN_Obj.length; i++){
        int ii = arN_Obj[i].getPositionY();
        char ch = arN_Obj[i].getPositionX();
        String dfe = new StringBuilder().append(ch).append(ii).toString();
        arCoordinate[i]  = dfe;

    }
    Checkers.setArrStatCoord(arCoordinate);
}



    public Checkers whoName(char x, int y){


    String XY = new StringBuilder().append(x).append(y).toString();

/*
    System.out.println(dfe);
*/
     for(int i=0; i<arN_Obj.length; i++){
         int ii = arN_Obj[i].getPositionY();
         char ch = arN_Obj[i].getPositionX();
         String dfe = new StringBuilder().append(ch).append(ii).toString();
         arCoordinate[i]  = dfe;

     }
     Checkers.setArrStatCoord(arCoordinate);
    Checkers ret =new Checkers(1000,'u') ;
    for(int i=0; i<arN_Obj.length;i++ ){
         if(arCoordinate[i].equals(XY)){
             ret = arN_Obj[i];
             success_choose=true;
         }


    }

    return ret;

    }


}