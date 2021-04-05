    public class Kisi {

        private int id;
        private String Adı;
        private String Soyadı;
        private String Numara;

        public Kisi(String Adı,String Soyadı,String Numara){
            this.Adı=Adı;
            this.Soyadı=Soyadı;
            this.Numara=Numara;
        }

        public int getId(){return this.id;}
        public String getAdı(){
            return this.Adı;
        }
        public String getSoyadı(){
            return this.Soyadı;
        }
        public String getNumara(){
            return this.Numara;
        }

        public void setId(int id) {
            this.id = id + 1;
        }
    }
