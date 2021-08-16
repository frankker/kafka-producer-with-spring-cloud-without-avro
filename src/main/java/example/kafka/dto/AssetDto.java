package example.kafka.dto;

import lombok.Data;

@Data
public class AssetDto {
  private long id;
  private long tenantId;
  private String name;
}
