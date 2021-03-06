package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoPrincipal;
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
public interface ProgramacionEventoPrincipalDAO extends JpaRepository<BeanProgramacionEventoPrincipal, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO, NTIPO_ASIGNACION_CODIGO, NBRIGADA_CODIGO, NTIPO_COMBUSTIBLE_CODIGO, "
            + "VEVENTO_PRINCIPAL_CODIGO, VEVENTO_PRINCIPAL_NOMBRE, NEVENTO_PRINCIPAL_NIVEL, "
            + "NEVENTO_PRINCIPAL_NIVELES, CEVENTO_PRINCIPAL_FINAL, VEVENTO_PRINCIPAL_PRINCIPAL, "
            + "PK_SINTE.FUN_CNV_TOTAL(CPERIODO_CODIGO, NBRIGADA_CODIGO, NTIPO_ASIGNACION_CODIGO, VEVENTO_PRINCIPAL_CODIGO) NEVENTO_PRINCIPAL_TOTAL, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_PROG_EVENTO_PRINCIPAL WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 AND "
            + "NBRIGADA_CODIGO=?3 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO=?4 AND "
            + "NEVENTO_PRINCIPAL_NIVEL=0 "
            + "ORDER BY VEVENTO_PRINCIPAL_CODIGO")
    List<BeanProgramacionEventoPrincipal> findByPeriodoTipoAsignacionBrigada(String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible);

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO, NTIPO_ASIGNACION_CODIGO, NBRIGADA_CODIGO, NTIPO_COMBUSTIBLE_CODIGO, "
            + "VEVENTO_PRINCIPAL_CODIGO, VEVENTO_PRINCIPAL_NOMBRE, NEVENTO_PRINCIPAL_NIVEL, "
            + "NEVENTO_PRINCIPAL_NIVELES, CEVENTO_PRINCIPAL_FINAL, VEVENTO_PRINCIPAL_PRINCIPAL, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO, 0 NEVENTO_PRINCIPAL_TOTAL "
            + "FROM SINTE_PROG_EVENTO_PRINCIPAL WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 AND "
            + "NBRIGADA_CODIGO=?3 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO=?4 AND "
            + "VEVENTO_PRINCIPAL_PRINCIPAL=?5 AND "
            + "NEVENTO_PRINCIPAL_NIVEL=?6 "
            + "ORDER BY VEVENTO_PRINCIPAL_CODIGO")
    List<BeanProgramacionEventoPrincipal> findByPeriodoTipoAsignacionBrigadaEventoPrincipalNivel(String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible, String eventoPrincipal, Integer nivel);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_PROG_EVENTO_PRINCIPAL(:periodo, :tipoAsignacion, :brigada, :tipoCombustible, :codigo, :eventoPrincipal, :nivel, :niveles, :eventoFinal, :usuario, :modo)}", nativeQuery = true)
    void sp_programacionEventoPrincipal(
            @Param("periodo") String periodo,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("brigada") Integer brigada,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("codigo") String codigo,
            @Param("eventoPrincipal") String eventoPrincipal,
            @Param("nivel") Integer nivel,
            @Param("niveles") Integer niveles,
            @Param("eventoFinal") Integer eventoFinal,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
