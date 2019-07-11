package tp2.redes;

/**
 * EnderecoFora
 */
public class EnderecoFora {
    private int vezesOff = 0;
    private int totalTimeoff = 0;
    long bigTimeOff = 0;
    
    public void esteveOff(long timeOff){
        this.setTotalTimeoff(timeOff);
        this.setVezesOffiline();
        this.bigtimeoffline(timeOff);
        
    }
    
    private void setVezesOffiline(){
        this.vezesOff += 1;
    }
    
    private void setTotalTimeoff(long timeOff) {
        this.totalTimeoff += timeOff;
    }

    public long getBigTimeOff() {
        return bigTimeOff;
    }

    public int getTotalTimeoff() {
        return totalTimeoff;
    }

    public int getVezesOff() {
        return vezesOff;
    }
    
    public void bigtimeoffline(long newTimeoff) {
        if (newTimeoff > this.bigTimeOff) {
            this.bigTimeOff = newTimeoff;
        }
    }

}