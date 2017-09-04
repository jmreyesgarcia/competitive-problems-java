import java.io.BufferedReader;
import java.io.BufferedWriter;
public class RPC_2017_09_Bolivia_I_SmallestGreater {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamReader(System.out));

        String l = br.readLine();
        while (l != null) {
            String[] par = l.split(" ");
            long M = Long.parseLong(par[0]);
            long K = Long.parseLong(par[1]);
            String Mb2 = Long.toString(M,2);
            int unosCons = 0;
            int unosDesp = 0;
            boolean cons = true;
            for(int i=0;i<Mb2.length();i++){
                if(Mb2.charAt(i)=='1'){
                    if(cons){
                        unosCons++;
                    }else{
                        unosDesp++;
                    }
                }else{
                    cons = false;
                }
            }
            String out = "";
            if(unosCons<K){
                for(int i=0;i<K;i++){
                    out += "1";
                }
                for(int i=K;i<Mb2.length();i++){
                    out += "0";
                }
                long outL = Long.parseLong(out,2);
                bw.write(outL+"\n");
            }else if(unosCons==K && unosDesp==0){
                bw.write(M+"\n");
            }else{
                for(int i=0;i<K;i++){
                    out += "1";
                }
                for(int i=K;i<=Mb2.length();i++){
                    out += "0";
                }
                long outL = Long.parseLong(out,2);
                bw.write(outL+"\n");
            }
            l = br.readLine();
        }
    }
}