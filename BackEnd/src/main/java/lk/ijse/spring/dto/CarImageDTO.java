package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarImageDTO {
    private MultipartFile front;
    private MultipartFile back;
    private MultipartFile side;
    private MultipartFile interior;
}
