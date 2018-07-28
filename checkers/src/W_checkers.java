public class W_checkers extends Checkers {
    public boolean dead = false;
    public char color = 'w';
    public int PosDel = -1;
    public boolean muve_or_kick_happen=false;
    public W_checkers(int y, char x){
        super(y,x);

    }

    public boolean checkMuve(char X, int Y){
        if(StepUp( X,  Y)||(kick(X,Y)))return true;
        else return false;
    }


    public int getPosKing(char x, int y){
        if(muve_or_kick_happen==true) {
            muve_or_kick_happen = false;
            if (y == 8) {
                String XY = new StringBuilder().append(x).append(y).toString();
                for (int i = 0; i < arStatCoord.length; i++) {

                    if (arStatCoord[i].equals(XY)) {

                        return i;
                    }

                }
            }
        }
        return -1;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    private boolean kick(char x, int y) {
        if(ValidMuve(x,y)){
            if(ClearBox(x,y)){
                if(NearEnemy(x,y)){
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    private boolean NearEnemy(char x, int y) {

        int Xx_i_prev =  getPositionX()-2;
        char Xx_ch_prev = (char) Xx_i_prev;
        int yToClearBox =0;
        char xToClearBox = 'p';
        String XY;
        if(Xx_ch_prev == x){
            if(getPositionY()+2 == y ){
                int Xx_i_prev_two =  getPositionX()-1;
                char Xx_ch_prev_two = (char) Xx_i_prev_two;
                yToClearBox = getPositionY()+1;
                xToClearBox = Xx_ch_prev_two;
                XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY()+1).toString();


            }else{
                int Xx_i_prev_two =  getPositionX()-1;
                char Xx_ch_prev_two = (char) Xx_i_prev_two;
                yToClearBox = getPositionY()-1;
                xToClearBox = Xx_ch_prev_two;
                 XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY()-1).toString();

            }
        }else{
            if(getPositionY()+2 == y ){
                int Xx_i_prev_two =  getPositionX()+1;
                char Xx_ch_prev_two = (char) Xx_i_prev_two;
                yToClearBox = getPositionY()+1;
                xToClearBox = Xx_ch_prev_two;
                XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY()+1).toString();

            }else{
                int Xx_i_prev_two =  getPositionX()+1;
                char Xx_ch_prev_two = (char) Xx_i_prev_two;
                yToClearBox = getPositionY()-1;
                xToClearBox = Xx_ch_prev_two;
                 XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY()-1).toString();

            }
        }

        if(ClearBox(xToClearBox,yToClearBox)){

            return false;
        }else{
            for (int i=0; i<arStatCoord.length; i++){
                if(arStatCoord[i].equals(XY)) {
                    if(arStatColor[i] == color){

                        return false;
                    }else {
                        PosDel = i;
                        return true;
                    }
                }
            }

        }




    return true;

    }

    public char getColor(){
        return color;
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









    public int[][] Capabilitie_kick(){
        int yToClearBox =0;
        char xToClearBox = 'p';
        int [][] ar_capab_kick= new int[4][15];
        String XY="";
        if(!dead){

//1111111111
            char xToClearBox_char;
            int Xx_i_prev_two =  getPositionX()-1;
            char Xx_ch_prev_two = (char) Xx_i_prev_two;
            yToClearBox = getPositionY()-2;
            int xToClearBox_int =  getPositionX()-2;
            if((xToClearBox_int>=65)&&(yToClearBox>=1)) {
                xToClearBox_char = (char) xToClearBox_int;
                xToClearBox = xToClearBox_char;
                XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY() - 1).toString();
                for (int i = 0; i < arStatCoord.length; i++) {
                    if (arStatCoord[i].equals(XY)) {
                        if (arStatColor[i] == color) {

                        } else {

                            if (ClearBox(xToClearBox, yToClearBox)) {
                                char x_char = xToClearBox;
                                int CoordPx_X = (x_char - 65) * 40 + 51;
                                int CoordPx_Y = (8 - yToClearBox) * 40 + 51;
                                ar_capab_kick[0][0] = CoordPx_X;
                                ar_capab_kick[0][1] = CoordPx_Y;
                            }


                        }
                    }
                }
            }


//222222
            Xx_i_prev_two =  getPositionX()+1;
            Xx_ch_prev_two = (char) Xx_i_prev_two;
            yToClearBox = getPositionY()-2;
            xToClearBox_int =  getPositionX()+2;
            if((xToClearBox_int<=72)&&(yToClearBox>=1)) {
                xToClearBox_char = (char) xToClearBox_int;
                xToClearBox = xToClearBox_char;
                XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY() - 1).toString();
                for (int i = 0; i < arStatCoord.length; i++) {
                    if (arStatCoord[i].equals(XY)) {
                        if (arStatColor[i] == color) {

                        } else {
                            if (ClearBox(xToClearBox, yToClearBox)) {
                                char x_char = xToClearBox;
                                int CoordPx_X = (x_char - 65) * 40 + 51;
                                int CoordPx_Y = (8 - yToClearBox) * 40 + 51;
                                ar_capab_kick[1][0] = CoordPx_X;
                                ar_capab_kick[1][1] = CoordPx_Y;
                            }


                        }
                    }
                }
            }


//33333333

            Xx_i_prev_two =  getPositionX()-1;
            Xx_ch_prev_two = (char) Xx_i_prev_two;
            yToClearBox = getPositionY()+2;
            xToClearBox_int =  getPositionX()-2;
            if((xToClearBox_int>=65)&&(yToClearBox<=8)) {
                xToClearBox_char = (char) xToClearBox_int;
                xToClearBox = xToClearBox_char;
                XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY() + 1).toString();
                for (int i = 0; i < arStatCoord.length; i++) {
                    if (arStatCoord[i].equals(XY)) {
                        if (arStatColor[i] == color) {

                        } else {
                            if (ClearBox(xToClearBox, yToClearBox)) {
                                char x_char = xToClearBox;
                                int CoordPx_X = (x_char - 65) * 40 + 51;
                                int CoordPx_Y = (8 - yToClearBox) * 40 + 51;
                                ar_capab_kick[2][0] = CoordPx_X;
                                ar_capab_kick[2][1] = CoordPx_Y;
                                // System.out.println("CoordPx_X");
                                //System.out.println(CoordPx_X);
                            }


                        }
                    }
                }
            }



//444444
            Xx_i_prev_two =  getPositionX()+1;
            Xx_ch_prev_two = (char) Xx_i_prev_two;
            yToClearBox = getPositionY()+2;
            xToClearBox_int =  getPositionX()+2;
            if((xToClearBox_int<=72)&&(yToClearBox<=8)) {
                xToClearBox_char = (char) xToClearBox_int;
                xToClearBox = xToClearBox_char;
                XY = new StringBuilder().append(Xx_ch_prev_two).append(getPositionY() + 1).toString();
                for (int i = 0; i < arStatCoord.length; i++) {
                    if (arStatCoord[i].equals(XY)) {
                        if (arStatColor[i] == color) {

                        } else {
                            if (ClearBox(xToClearBox, yToClearBox)) {
                                char x_char = xToClearBox;
                                int CoordPx_X = (x_char - 65) * 40 + 51;
                                int CoordPx_Y = (8 - yToClearBox) * 40 + 51;
                                ar_capab_kick[3][0] = CoordPx_X;
                                ar_capab_kick[3][1] = CoordPx_Y;
                            }

                        }
                    }
                }
            }




        }return ar_capab_kick;
    }










    private boolean ValidMuve(char x, int y) {
        int Xx_i_prev =  getPositionX()-2;
        char Xx_ch_prev = (char) Xx_i_prev;
        int Xx_i_next =  getPositionX()+2;
        char Xx_ch_next = (char) Xx_i_next;


        if(((Xx_ch_next == x)||(Xx_ch_prev == x))&&((getPositionY()+2 == y )||(getPositionY()-2 == y ))){

            return true;
        }else return false;
    }

    private boolean StepUp(char x, int y) {
        if(ClearBox(x,y)){

            int Xx_i_prev =  getPositionX()-1;
            char Xx_ch_prev = (char) Xx_i_prev;
            int Xx_i_next =  getPositionX()+1;
            char Xx_ch_next = (char) Xx_i_next;


           if(((Xx_ch_next == x)||(Xx_ch_prev == x))&&(getPositionY()+1 == y )) return true;
           else return false;
      }else return false;
    }





    public int Muve( char X , int Y){
        PosDel=-1;
        if(checkMuve(X,Y)){
            setPositionY(Y);
            setPositionX(X);
            muve_or_kick_happen=true;
            if(PosDel == -1)PosDel =200;
            return PosDel;
        }

        return PosDel;
    }


}
