package API.dto;

import com.google.gson.annotations.SerializedName;
import dto.Lead;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

@Data
@Builder
public class LeadsList {
    @SerializedName("recentItems")
    private ArrayList<Lead> leadsList;

    public Lead getRandomLeadFromList() {
        return getLeadsList().get(RandomUtils.nextInt(0, getLeadsList().size()));
    }
}
