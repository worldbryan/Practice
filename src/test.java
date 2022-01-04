import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List<Worker> workers = buildWorkers();
        List<Boss> bosses = buildBosses();
        int totalBenefit = 0;
        int totalPay = 0;

        for(Worker worker : workers) {
            totalBenefit += worker.getBenefit();
            totalPay += worker.getSalary();

            Boss tmpBoss = new Boss();
            //會有問題
            //Boss tmpBoss2 = bosses.get((worker.getBelongBoss()));
            int prevBene = bosses.get((worker.getBelongBoss())).getBenefit();
            int prevPay = bosses.get((worker.getBelongBoss())).getPaySalary();
            tmpBoss.setBenefit(prevBene + worker.getBenefit());
            tmpBoss.setPaySalary(prevPay + worker.getSalary());
            bosses.set(worker.getBelongBoss(), tmpBoss);
        }
        System.out.println("總收入: "+totalBenefit);
        System.out.println("總付出: "+totalPay);
        for (int i =0; i<10; i++){
            System.out.print("老闆 "+i+"收入: "+bosses.get(i).getBenefit());
            System.out.println(" 老闆 "+i+"付出: "+bosses.get(i).getPaySalary());
        }
    }

    private static List buildWorkers() {
        List<Worker> workers = new ArrayList();
        for (int i =0; i < 1000; i++) {
            Worker tempWorker = new Worker();
            tempWorker.setBelongBoss((int)(Math.random()*10));
            tempWorker.setSalary((int)(Math.random()*50) + 51);
            tempWorker.setBenefit((int)(Math.random()*100) + 901);
            workers.add(tempWorker);
        }
        return workers;
    }

    private static List buildBosses() {
        List<Boss> bosses = new ArrayList<>();
        Boss tempboss = new Boss();
        tempboss.setBenefit(0);
        tempboss.setPaySalary(0);
        for (int i =0; i<10; i++) {
            bosses.add(tempboss);
        }
        return bosses;
    }
}
