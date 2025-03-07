package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @InjectMocks
    VetSDJpaService vetSDJpaService;
    @Mock
    VetRepository vetRepository;

    @Test
    void deleteById() {
        vetSDJpaService.deleteById(1L);

        verify(vetRepository).deleteById(1L);
    }
}