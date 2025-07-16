package lombok_read_Json_Data;

import java.util.List;
import lombok.Data;

@Data
public class Reqres_userList_POJO {
	
	// we can store Integer data into String variable
	int page;
	int per_page;
	int total;
	String total_pages;
	List<DataPOJO> data;
	SupportPOJO support;
}
