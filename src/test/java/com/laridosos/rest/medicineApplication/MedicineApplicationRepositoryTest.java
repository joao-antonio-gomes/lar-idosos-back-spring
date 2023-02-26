package com.laridosos.rest.medicineApplication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MedicineApplicationRepositoryTest {

    @Autowired
    private MedicineApplicationRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Quando buscar por aplicações não realizadas anterior a data, não deve retornar nenhuma aplicação, pois não há nenhuma aplicação não realizada")
    void naoDeveRetornarAplicacoes_quandoBuscarPorAplicacoesNaoRealizadas_poisNaoExistem() {
        cadastrarMedApplications();

        var medicineApplicationsPageable = repository.findLatedMedicineApplication(
                LocalDate.of(2020, 2, 8),
                LocalTime.of(10, 0),
                null);

        var medApplications = medicineApplicationsPageable.getContent();
        assertTrue(medApplications.isEmpty());
    }

    @Test
    @DisplayName("Quando buscar por aplicações não realizadas anterior a data, deve retornar uma aplicação, pois há uma aplicação não realizada")
    void deveRetornarUmaAplicacao_quandoBuscarPorAplicacoesNaoRealizadas() {
        cadastrarMedApplications();

        var medicineApplicationsPageable = repository.findLatedMedicineApplication(
                LocalDate.of(2020, 2, 10),
                LocalTime.of(11, 0),
                null);

        var medApplications = medicineApplicationsPageable.getContent();
        assertFalse(medApplications.isEmpty());
        assertEquals(1, medApplications.size());
    }

    @Test
    @DisplayName("Quando buscar por aplicações realizadas, não deve retornar nenhuma aplicação, pois não há nenhuma aplicação realizada")
    void naoDeveRetornarAplicacoes_quandoBuscarPorAplicacoesRealizadas_poisNaoExistem() {
        cadastrarMedApplications();

        var medicineApplicationsPageable = repository.findReleasedMedicineApplication(
                LocalDate.of(2020, 2, 6),
                LocalTime.of(10, 0),
                null);

        var medApplications = medicineApplicationsPageable.getContent();
        assertTrue(medApplications.isEmpty());
    }

    @Test
    @DisplayName("Quando buscar por aplicações realizadas, deve retornar uma aplicação, pois há uma aplicação realizada")
    void deveRetornarUmaAplicacao_quandoBuscarPorAplicacoesRealizadas() {
        cadastrarMedApplications();

        var medicineApplicationsPageable = repository.findReleasedMedicineApplication(
                LocalDate.of(2020, 2, 7),
                LocalTime.of(10, 0, 1),
                null);

        var medApplications = medicineApplicationsPageable.getContent();
        assertFalse(medApplications.isEmpty());
        assertEquals(1, medApplications.size());
    }

    @Test
    @DisplayName("Quando buscar por aplicações a serem realizadas, não deve retornar nenhuma aplicação, pois não há nenhuma aplicação a ser realizada")
    void naoDeveRetornarAplicacoes_quandoBuscarPorAplicacoesASeremRealizadas_poisNaoExistem() {
        cadastrarMedApplications();

        var medicineApplicationsPageable = repository.findToBeAppliedMedicineApplication(
                LocalDate.of(2020, 2, 10),
                LocalTime.of(10, 0),
                null);

        var medApplications = medicineApplicationsPageable.getContent();
        assertTrue(medApplications.isEmpty());
    }

    @Test
    @DisplayName("Quando buscar por aplicações a serem realizadas, deve retornar uma aplicação, pois há uma aplicação a ser realizada")
    void deveRetornarUmaAplicacao_quandoBuscarPorAplicacoesASeremRealizadas() {
        cadastrarMedApplications();

        var medicineApplicationsPageable = repository.findToBeAppliedMedicineApplication(
                LocalDate.of(2020, 2, 9),
                LocalTime.of(10, 0),
                null);

        var medApplications = medicineApplicationsPageable.getContent();
        assertFalse(medApplications.isEmpty());
        assertEquals(1, medApplications.size());
    }

    private void cadastrarMedApplications() {
        var medApplication1 = MedicineApplication.builder()
                                                 .applied(false)
                                                 .date(LocalDate.of(2020, 2, 10))
                                                 .hour(LocalTime.of(10, 0))
                                                 .build();
        var medApplication2 = MedicineApplication.builder()
                                                 .applied(true)
                                                 .date(LocalDate.of(2020, 2, 7))
                                                 .hour(LocalTime.of(10, 0))
                                                 .build();
        entityManager.persist(medApplication1);
        entityManager.persist(medApplication2);
    }
}
