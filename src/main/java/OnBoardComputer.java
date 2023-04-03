public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 0;
        //4501
        if((status.getAltitude() - status.getVelocity() < 4501
                && status.getVelocity() !=100
                && status.getAltitude() > 100)) {
            burn = 200;
        }else if((status.getVelocity() == 100
                && status.getAltitude()-status.getVelocity()>0)
                || status.getAltitude() - status.getVelocity() > 4501
                || status.getVelocity() < status.getAltitude()){
            burn = 100;
        }else if(status.getVelocity() == 100
                && status.getAltitude() <100){
            burn = 201 - status.getAltitude();
        }else if(status.getVelocity()<100
                && status.getAltitude()<100
                && status.getVelocity()< status.getAltitude()){
            burn = 100 + status.getAltitude() - status.getVelocity();
        }else if (status.getVelocity() > status.getAltitude()
                || status.getVelocity() == status.getAltitude()){
            burn = 100 + status.getVelocity()-2;
        }
        System.out.println(burn); /*hack!*/
        return burn;
    }

}
