package cho.ym.madrascheck.extension.fixed.application;

import cho.ym.madrascheck.enums.FixedFileExtension;
import cho.ym.madrascheck.extension.fixed.web.response.FixedFileExtensionResponse;
import cho.ym.madrascheck.extension.fixed.repository.FixedFileExtensionRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FixedFileExtensionService {

    private final FixedFileExtensionRepository repository;

    public FixedFileExtensionService(FixedFileExtensionRepository repository) {
        this.repository = repository;
    }

    public List<FixedFileExtensionResponse> allFixedFileExtensions() {
        return Arrays.stream(FixedFileExtension.values())
                .map(fixedFileExtension -> {
                    System.out.println(fixedFileExtension);
                    return FixedFileExtensionResponse.of(fixedFileExtension.getExtension()
                                    , fixedFileExtension.getName()
                                    , repository.isChecked(fixedFileExtension));
                        }
                ).toList();
    }

    public boolean isChecked(String extension) {
        return repository.isChecked(FixedFileExtension.fromExtension(extension));
    }

    public void check(String extension) {
        repository.check(FixedFileExtension.fromExtension(extension));
    }

    public void cancel(String extension) {
        repository.cancel(FixedFileExtension.fromExtension(extension));
    }
}
