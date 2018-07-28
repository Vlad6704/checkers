public class King_B_Checkers extends Checkers {

    @Override
    public char getColor() {
        return color;
    }

    public char color = 'b';
    private int kingMuve=0;
    public int PosDel = -1;
    public boolean dead = false;
    boolean two_enamy=false;

    public King_B_Checkers(int posY, char posX) {
        super(posY, posX);
    }


    public int Muve( char X , int Y){
        PosDel=-1;
        if(checkMuve(X,Y)){
            setPositionY(Y);
            setPositionX(X);
            if(PosDel == -1)PosDel =200;
            return PosDel;
        }
        return PosDel;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean checkMuve(char X, int Y){
        //System.out.println("StepUp = ");
       // System.out.println(StepUp( X,  Y));
       // System.out.println("kingMuve = ");
      //  System.out.println(kingMuve);
        if((ClearBox(X,Y))&&(StepUp( X,  Y)||(kick(X,Y)))){

            return true;
        }
        else return false;
    }



    private boolean StepUp(char x, int y) {
       char Xx_PosNow = getPositionX();
       int Yy_PosNow = getPositionY();
       if((y > Yy_PosNow) && ( x < Xx_PosNow)){
           //up_left
           //System.out.println("up_left");
           int diferentX = Xx_PosNow - x;
            for(int i = 1; i<=diferentX; i++){
                int Xx_i_prev =  getPositionX()-i;
                char Xx_ch_prev = (char) Xx_i_prev;
                if(!ClearBox(Xx_ch_prev,getPositionY()+i))return false;
            }

            return true;

       }else if ((y > Yy_PosNow) && ( x > Xx_PosNow)){
           //up_ridht

           int diferentX = x-Xx_PosNow;
           for(int i = 1; i<=diferentX; i++){

               int Xx_i_prev_o =  getPositionX()+i;
               char Xx_ch_prev = (char) Xx_i_prev_o;
               //System.out.println(getPositionY()+i);
               if(!ClearBox(Xx_ch_prev,getPositionY()+i)){

                   return false;
               }
           }

           return true;
       }else if( (y < Yy_PosNow) && ( x < Xx_PosNow)){
          // down_left
          // System.out.println("down_left");
           int diferentX = Xx_PosNow - x;
           for(int i = 1; i<=diferentX; i++){
               int Xx_i_prev_o =  getPositionX()-i;
               char Xx_ch_prev = (char) Xx_i_prev_o;

               if(!ClearBox(Xx_ch_prev,getPositionY()-i)){



                   return false;
               }
           }
           return true;
       }else if((y < Yy_PosNow) && ( x > Xx_PosNow)){
           //down_right
          // System.out.println("down_right");
           int diferentX = x-Xx_PosNow ;
           for(int i = 1; i<=diferentX; i++){
               int Xx_i_prev =  getPositionX()+i;
               char Xx_ch_prev = (char) Xx_i_prev;
               if(!ClearBox(Xx_ch_prev,getPositionY()-i))return false;
           }
           return true;
       }else return false;

    }

    private boolean ClearBox(char x, int y) {
        String XY = new StringBuilder().append(x).append(y).toString();
        Boolean trueORfalse = false;
        for(String i:arStatCoord){
            if(i.equals(XY)) {
                return false;
            }else {
                trueORfalse = true;
            }
        }

        return trueORfalse;
    }
    private boolean CheckBoxKing(char x, int y) {

        String XY = new StringBuilder().append(x).append(y).toString();
        Boolean trueORfalse = false;
        for(int i=0; i<arStatCoord.length;i++){

            if(arStatCoord[i].equals(XY)) {
                if(arStatColor[i]!=color){
                    if(!two_enamy){

                        two_enamy=true;
                            if(kingMuve==0){
                                kingMuve =1;
                                PosDel=i;

                                return true;
                            }else return false;
                    }else {
                        PosDel=-1;
                        return false;
                    }
                }else return false;




            }else {
                trueORfalse = true;
            }
        }

        return trueORfalse;
    }


    private boolean kick(char x, int y) {
         two_enamy=false;


        char Xx_PosNow = getPositionX();
        int Yy_PosNow = getPositionY();
        if((y > Yy_PosNow) && ( x < Xx_PosNow)){
            //up_left

            int diferentX = Xx_PosNow - x;
            for(int i = 1; i<diferentX; i++){
                int Xx_i_prev =  getPositionX()-i;
                char Xx_ch_prev = (char) Xx_i_prev;
                if(!CheckBoxKing(Xx_ch_prev,getPositionY()+i)){
                    kingMuve=0;
                    return false;
                }
            }
            kingMuve=0;
            return true;

        }else if ((y > Yy_PosNow) && ( x > Xx_PosNow)){
            //up_ridht

            int diferentX = x-Xx_PosNow;
            for(int i = 1; i<diferentX; i++){

                int Xx_i_prev_o =  getPositionX()+i;
                char Xx_ch_prev = (char) Xx_i_prev_o;
                //System.out.println(getPositionY()+i);
                if(!CheckBoxKing(Xx_ch_prev,getPositionY()+i)){
                    kingMuve=0;
                    return false;
                }
            }
            kingMuve=0;
            return true;
        }else if( (y < Yy_PosNow) && ( x < Xx_PosNow)){
            // down_left

            int diferentX = Xx_PosNow - x;
            for(int i = 1; i<diferentX; i++){
                int Xx_i_prev_o =  getPositionX()-i;
                char Xx_ch_prev = (char) Xx_i_prev_o;

                if(!CheckBoxKing(Xx_ch_prev,getPositionY()-i)){


                    kingMuve=0;
                    return false;
                }
            }
            kingMuve=0;
            return true;
        }else if((y < Yy_PosNow) && ( x > Xx_PosNow)){
            //down_right

            int diferentX = x-Xx_PosNow ;
            for(int i = 1; i<diferentX; i++){
                int Xx_i_prev =  getPositionX()+i;
                char Xx_ch_prev = (char) Xx_i_prev;
                if(!CheckBoxKing(Xx_ch_prev,getPositionY()-i)){
                    kingMuve=0;
                    return false;
                }
            }
            kingMuve=0;
            return true;
        }else return false;

    }



    public int getPosKing(char x, int y){
        return -1;
    }


    public int[][] Capabilitie_kick(){









        int [][] ar_capab_kick= new int[4][15];
        int Yy = getPositionY();
        int Xx =  getPositionX() -64;
        boolean find_enamy=false;
        boolean good_coord=false;
        boolean brea=false;
        int up_right=0;
        int up_left=0;
        int down_right=0;
        int down_left=0;




 //////up_right
       if(Yy - Xx>=0){
           up_right = 8 - Yy ;

       }else{
           up_right = 8 - Xx;
       }

         find_enamy=false;
         good_coord=false;
         brea=false;
        for(int e = 1; e<=up_right;e++) {
            int Yy_Pos = getPositionY() + e;
            int Xx_Pos = getPositionX() + e;
            char x_char = (char)Xx_Pos;
            char Xx_Pos_char = (char) Xx_Pos;

            String XY = new StringBuilder().append(Xx_Pos_char).append(Yy_Pos).toString();
            for (int i = 0; i < arStatCoord.length; i++) {
                if (arStatCoord[i].equals(XY)) {
                    if (arStatColor[i] == color) {
                        good_coord=false;
                        brea=true;

                        break;
                    }else {
                        if(!find_enamy){
                            find_enamy=true;
                            break;
                        }else{
                            good_coord=false;
                            brea=true;
                            break;
                        }
                    }
                }else {
                    if(find_enamy){
                      good_coord=true;
                    }
                }
            }
            if(good_coord){
                good_coord=false;
                int CoordPx_X = (x_char - 65) * 40 + 60;
                int CoordPx_Y = (8 - Yy_Pos) * 40 + 60;
                ar_capab_kick[0][e*2-1]=CoordPx_X;
                ar_capab_kick[0][e*2]=CoordPx_Y;


            }else if(brea){
                break;
            }

        }




////////up_left
        int Xx_n=9-Xx;
        if(Yy - Xx_n>=0){
            up_left = 8 - Yy ;

        }else{
            up_left = 8 - Xx_n;
        }

        find_enamy=false;
        good_coord=false;
        brea=false;
        for(int e = 1; e<=up_left;e++) {
           int Yy_Pos = getPositionY() + e;
           int Xx_Pos = getPositionX() - e;
            char x_char = (char)Xx_Pos;
            char Xx_Pos_char = (char) Xx_Pos;

            String XY = new StringBuilder().append(Xx_Pos_char).append(Yy_Pos).toString();
            for (int i = 0; i < arStatCoord.length; i++) {
                if (arStatCoord[i].equals(XY)) {
                    if (arStatColor[i] == color) {
                        good_coord=false;
                        brea=true;

                        break;
                    }else {
                        if(!find_enamy){
                            find_enamy=true;
                            break;
                        }else{
                            good_coord=false;
                            brea=true;
                            break;
                        }
                    }
                }else {
                    if(find_enamy){
                      good_coord=true;
                    }
                }
            }
            if(good_coord){
                good_coord=false;
                int CoordPx_X = (x_char - 65) * 40 + 60;
                int CoordPx_Y = (8 - Yy_Pos) * 40 + 60;
                ar_capab_kick[1][e*2-1]=CoordPx_X;
                ar_capab_kick[1][e*2]=CoordPx_Y;


            }else if(brea){
                break;
            }

        }




////////down_right

        Xx_n=9-Xx;
        if(Yy - Xx_n>=0){
            down_right = Xx_n -1 ;

        }else{
            down_right = Yy-1;
        }

        find_enamy=false;
        good_coord=false;
        brea=false;
        for(int e = 1; e<=down_right;e++) {
            int Yy_Pos = getPositionY() - e;
            int Xx_Pos = getPositionX() + e;
            char x_char = (char)Xx_Pos;
            char Xx_Pos_char = (char) Xx_Pos;

            String XY = new StringBuilder().append(Xx_Pos_char).append(Yy_Pos).toString();
            for (int i = 0; i < arStatCoord.length; i++) {
                if (arStatCoord[i].equals(XY)) {
                    if (arStatColor[i] == color) {
                        good_coord=false;
                        brea=true;

                        break;
                    }else {
                        if(!find_enamy){
                            find_enamy=true;
                            break;
                        }else{
                            good_coord=false;
                            brea=true;
                            break;
                        }
                    }
                }else {
                    if(find_enamy){
                        good_coord=true;
                    }
                }
            }
            if(good_coord){
                good_coord=false;
                int CoordPx_X = (x_char - 65) * 40 + 60;
                int CoordPx_Y = (8 - Yy_Pos) * 40 + 60;
                ar_capab_kick[2][e*2-1]=CoordPx_X;
                ar_capab_kick[2][e*2]=CoordPx_Y;


            }else if(brea){
                break;
            }

        }




////////down_left


        if(Yy - Xx>=0){
            down_left = Xx -1 ;

        }else{
            down_left = Yy-1;
        }

        find_enamy=false;
        good_coord=false;
        brea=false;
        for(int e = 1; e<=down_left;e++) {
            int Yy_Pos = getPositionY() - e;
            int Xx_Pos = getPositionX() - e;
            char x_char = (char)Xx_Pos;
            char Xx_Pos_char = (char) Xx_Pos;

            String XY = new StringBuilder().append(Xx_Pos_char).append(Yy_Pos).toString();
            for (int i = 0; i < arStatCoord.length; i++) {
                if (arStatCoord[i].equals(XY)) {
                    if (arStatColor[i] == color) {
                        good_coord=false;
                        brea=true;

                        break;
                    }else {
                        if(!find_enamy){
                            find_enamy=true;
                            break;
                        }else{
                            good_coord=false;
                            brea=true;
                            break;
                        }
                    }
                }else {
                    if(find_enamy){
                        good_coord=true;
                    }
                }
            }
            if(good_coord){
                good_coord=false;
                int CoordPx_X = (x_char - 65) * 40 + 60;
                int CoordPx_Y = (8 - Yy_Pos) * 40 + 60;
                ar_capab_kick[3][e*2-1]=CoordPx_X;
                ar_capab_kick[3][e*2]=CoordPx_Y;


            }else if(brea){
                break;
            }

        }








        return ar_capab_kick;
    }



}
