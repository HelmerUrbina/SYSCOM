package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface ProgramacionEventoFinalDAO extends JpaRepository<BeanProgramacionEventoFinal, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "NTIPO_OPERACION_CODIGO CPERIODO_CODIGO, NTIPO_ASIGNACION_CODIGO, NBRIGADA_CODIGO, NTIPO_COMBUSTIBLE_CODIGO, "
            + "VEVENTO_PRINCIPAL_CODIGO, NEVENTO_FINAL_CODIGO, VEVENTO_FINAL_NOMBRE, NEVENTO_FINAL_PRIORIDAD, "
            + "UTIL.FUN_TIPO_OPERACION_ABREVIATUR(NTIPO_OPERACION_CODIGO) NTIPO_OPERACION_CODIGO, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_PROG_EVENTO_FINAL WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 AND "
            + "NBRIGADA_CODIGO=?3 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO=?4 AND "
            + "VEVENTO_PRINCIPAL_CODIGO=?5  "
            + "ORDER BY NEVENTO_FINAL_CODIGO")
    List<BeanProgramacionEventoFinal> findByPeriodoTipoAsignacionBrigadaEventoPrincipal(String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible, String eventoPrincipal);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_PROG_EVENTO_FINAL(:periodo, :tipoAsignacion, :brigada, :tipoCombustible, :eventoPrincipal, :eventoFinal, "
            + ":eventoFinalNombre, :prioridad, :tipoOperacion, :usuario, :modo)}", nativeQuery = true)
    void sp_programacionEventoFinal(
            @Param("periodo") String periodo,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("brigada") Integer brigada,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("eventoPrincipal") String eventoPrincipal,
            @Param("eventoFinal") Integer eventoFinal,
            @Param("eventoFinalNombre") String eventoFinalNombre,
            @Param("prioridad") Integer prioridad,
            @Param("tipoOperacion") Integer tipoOperacion,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
