package cho.ym.madrascheck.extension.fixed.web;

import cho.ym.madrascheck.extension.fixed.application.FixedFileExtensionService;
import cho.ym.madrascheck.extension.fixed.web.response.FixedFileExtensionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class FixedExtensionController {

    private final FixedFileExtensionService service;

    public FixedExtensionController(FixedFileExtensionService service) {
        this.service = service;
    }

    @GetMapping("fixed-extensions")
    public ResponseEntity<List<FixedFileExtensionResponse>> getFixedExtensions() {
        return ResponseEntity.ok(service.allFixedFileExtensions());
    }

    @PostMapping("fixed-extensions/{extension}")
    public ResponseEntity<Void> addFixedExtension(@PathVariable String extension) {
        service.check(extension);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("fixed-extensions/{extension}")
    public ResponseEntity<Void> deleteFixedExtension(@PathVariable String extension) {
        service.cancel(extension);
        return ResponseEntity.noContent().build();
    }

}
