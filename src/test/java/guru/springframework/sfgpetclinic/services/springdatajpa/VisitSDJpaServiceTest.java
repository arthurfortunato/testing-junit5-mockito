package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @InjectMocks
    VisitSDJpaService visitSDJpaService;
    @Mock
    VisitRepository visitRepository;

    private final Visit visit = new Visit();

    @DisplayName("Should Find All")
    @Test
    void shouldFindAll() {

        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = visitSDJpaService.findAll();

        verify(visitRepository).findAll();

        assertThat(foundVisits).hasSize(1);
    }

    @DisplayName("Should Find By Id")
    @Test
    void shouldFindById() {

        when(visitRepository.findById(1L)).thenReturn(Optional.of(visit));

        Visit foundVisit = visitSDJpaService.findById(1L);

        assertEquals(foundVisit, visit);
        verify(visitRepository).findById(1L);
    }

    @DisplayName("Should Save")
    @Test
    void shouldSave() {
        visitSDJpaService.save(visit);

        verify(visitRepository).save(any(Visit.class));
    }

    @DisplayName("Should Delete")
    @Test
    void shouldDelete() {
        visitSDJpaService.delete(visit);

        verify(visitRepository).delete(any(Visit.class));
    }

    @DisplayName("Should Delete By Id")
    @Test
    void shouldDeleteById() {

        visitSDJpaService.deleteById(1L);
        visitSDJpaService.deleteById(1L);

        verify(visitRepository, times(2)).deleteById(anyLong());
    }
}