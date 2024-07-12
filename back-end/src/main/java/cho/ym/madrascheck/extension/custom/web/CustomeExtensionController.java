package cho.ym.madrascheck.extension.custom.web;

import cho.ym.madrascheck.extension.custom.application.CustomFileExtensionService;
import cho.ym.madrascheck.extension.custom.web.request.CustomFileExtensionRequest;
import cho.ym.madrascheck.extension.custom.web.response.CustomFileExtensionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CustomeExtensionController {

    private final CustomFileExtensionService service;

    public CustomeExtensionController(CustomFileExtensionService service) {
        this.service = service;
    }

    @GetMapping("custom-extensions")
    public ResponseEntity<List<CustomFileExtensionResponse>> getCustomExtensions() {
        return ResponseEntity.ok(service.allCustomFileExtensions());
    }

    @PostMapping("custom-extensions")
    public ResponseEntity<CustomFileExtensionResponse> addCustomExtension(CustomFileExtensionRequest request) {
        return ResponseEntity.ok(service.add(request));
    }

    @DeleteMapping("custom-extensions/{id}")
    public ResponseEntity<Void> deleteCustomExtension(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("custom-extensions/{id}")
    public ResponseEntity<CustomFileExtensionResponse> getCustomExtension(@PathVariable long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

}
