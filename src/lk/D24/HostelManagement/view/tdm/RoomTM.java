package lk.D24.HostelManagement.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/26/2022
 * Time :7:58 PM
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomTM {
    private String roomTypeId;
    private String type;
    private double keyMoney;
    private int qty;
}
