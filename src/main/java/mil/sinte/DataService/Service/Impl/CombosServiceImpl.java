package mil.sinte.DataService.Service.Impl;

import com.google.gson.Gson;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;
import mil.sinte.DataService.DAO.CombosDAO;
import mil.sinte.DataService.Service.CombosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class CombosServiceImpl implements CombosService {

    @Autowired
    private CombosDAO combosDAO;

    /*MODULO CONFIGURACION*/
    @Override
    public List<BeanCombos> getPeriodos() {
        return combosDAO.getPeriodos();
    }

    @Override
    public List<BeanCombos> getDivisionEjercito() {
        return combosDAO.getDivisionEjercito();
    }

    @Override
    public List<BeanCombos> getTipoCombustible() {
        return combosDAO.getTipoCombustible();
    }

    @Override
    public List<BeanCombos> getTipoOperacion() {
        return combosDAO.getTipoOperacion();
    }

    @Override
    public List<BeanCombos> getBrigadas() {
        return combosDAO.getBrigadas();
    }

    @Override
    public List<BeanCombos> getDepartamentos() {
        return combosDAO.getDepartamentos();
    }

    @Override
    public List<BeanCombos> getProvincias(String departamento) {
        return combosDAO.getProvincias(departamento);
    }

    @Override
    public List<BeanCombos> getUbigeo(String departamento, String provincia) {
        return combosDAO.getUbigeo(departamento, provincia);
    }

    @Override
    public List<BeanCombos> getTipoDependencia() {
        return combosDAO.getTipoDependencia();
    }

    @Override
    public List<BeanCombos> getBrigadasByUsuario(String usuario) {
        return combosDAO.getBrigadasByUsuario(usuario);
    }

    @Override
    public List<BeanCombos> getTipoCombustibleByVehiculo(Integer vehiculo) {
        return combosDAO.getTipoCombustibleByVehiculo(vehiculo);
    }

    @Override
    public List<BeanCombos> getFuenteFinanciamiento() {
        return combosDAO.getFuenteFinanciamiento();
    }

    /*MODULO PROGRAMACION*/
    @Override
    public List<BeanCombos> getPeriodoTipoAsignacionPendiente(String periodo) {
        return combosDAO.getPeriodoTipoAsignacionPendiente(periodo);
    }

    @Override
    public List<BeanCombos> getTipoAsignacionByPeriodo(String periodo) {
        return combosDAO.getTipoAsignacionByPeriodo(periodo);
    }

    @Override
    public List<BeanCombos> getBrigadasTechosByPeriodo(String periodo) {
        return combosDAO.getBrigadasTechosByPeriodo(periodo);
    }

    @Override
    public List<BeanCombos> getTipoAsignacionTechosByPeriodoAndBrigada(String periodo, Integer brigada) {
        return combosDAO.getTipoAsignacionTechosByPeriodoAndBrigada(periodo, brigada);
    }

    @Override
    public List<BeanCombos> getTipoCombustibleTechosByPeriodoAndBrigadaAndTipoAsignacion(String periodo, Integer brigada, Integer tipoAsignacion) {
        return combosDAO.getTipoCombustibleTechosByPeriodoAndBrigadaAndTipoAsignacion(periodo, brigada, tipoAsignacion);
    }

    @Override
    public List<BeanCombos> getDependenciasByPeriodoAndBrigadaAndTipoCombustible(String periodo, Integer brigada, Integer tipoCombustible) {
        return combosDAO.getDependenciasByPeriodoAndBrigadaAndTipoCombustible(periodo, brigada, tipoCombustible);
    }

    @Override
    public List<BeanCombos> getVehiculosCNVByPeriodoAndBrigadaAndTipoCombustibleAndDependencia(String periodo, Integer brigada, Integer tipoCombustible, Integer Dependencia) {
        return combosDAO.getVehiculosCNVByPeriodoAndBrigadaAndTipoCombustibleAndDependencia(periodo, brigada, tipoCombustible, Dependencia);
    }

    @Override
    public List<BeanCombos> getTipoVehiculo() {
        return combosDAO.getTipoVehiculo();
    }

    @Override
    public List<BeanCombos> getClaseVehiculo() {
        return combosDAO.getClaseVehiculo();
    }

    @Override
    public List<BeanCombos> getMarca() {
        return combosDAO.getMarca();
    }

    @Override
    public List<BeanCombos> getModelo(String marca) {
        return combosDAO.getModelo(marca);
    }

    @Override
    public List<BeanCombos> getColor() {
        return combosDAO.getColor();
    }

    @Override
    public List<BeanCombos> getSoat() {
        return combosDAO.getSoat();
    }

    @Override
    public List<BeanCombos> getAreaLaboral() {
        return combosDAO.getAreaLaboral();
    }

    @Override
    public List<BeanCombos> getRol() {
        return combosDAO.getRol();
    }

    @Override
    public List<BeanCombos> getVehiculosByPeriodoAndBrigadas(String periodo, Integer brigada) {
        return combosDAO.getVehiculosByPeriodoAndBrigada(periodo, brigada);
    }

    @Override
    public List<BeanCombos> getVehiculosByPeriodoAndBrigadasAndDependencia(String periodo, Integer brigada, Integer dependencia) {
        return combosDAO.getVehiculosByPeriodoAndBrigadaAndDependencia(periodo, brigada, dependencia);
    }

    @Override
    public List<BeanCombos> getDependenciaByVehiAndBrigAndPeri(String periodo, String brigada, String vehiculo) {
        return combosDAO.getDependenciaByVehiAndBrigAndPeri(periodo, Integer.parseInt(brigada), Integer.parseInt(vehiculo)
        );
    }

    @Override
    public List<BeanCombos> getVehiculosByPeriodo(String periodo) {
        return combosDAO.getVehiculosByPeriodo(periodo);
    }

    @Override
    public List<BeanCombos> getVehiculosByPeriodoBrigada(String periodo, Integer brigada) {
        return combosDAO.getVehiculosByPeriodoAndBrigada(periodo, brigada);
    }

    @Override
    public List<BeanCombos> getDependenciaByBrigada(String brigada) {
        return combosDAO.getDependenciaByBrigada(Integer.parseInt(brigada));
    }

    @Override
    public List<BeanCombos> getMeses() {
        return combosDAO.getMeses();
    }

    @Override
    public List<BeanCombos> getTipoCombustibleByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion) {
        return combosDAO.getTipoCombustibleByAsignacionCombustible(anio, brigada, mes, tipoAsignacion);
    }

    @Override
    public List<BeanCombos> getVehiculoByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible, Integer dependencia) {
        return combosDAO.getVehiculoByAsignacionCombustible(anio, brigada, mes, tipoAsignacion, tipoCombustible, dependencia);
    }

    @Override
    public List<BeanCombos> getCombsutibleByVariacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion) {
        return combosDAO.getCombsutibleByVariacion(periodo, brigada, mes, tipoAsignacion);
    }

    @Override
    public List<BeanCombos> getVehiculoByVariacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible, Integer dependencia) {
        return combosDAO.getVehiculoByVariacion(periodo, brigada, mes, tipoAsignacion, tipoCombustible, dependencia);
    }

    @Override
    public List<BeanCombos> getDependenciaByVariacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible) {
        return combosDAO.getDependenciaByVariacion(periodo, brigada, mes, tipoAsignacion, tipoCombustible);
    }

    @Override
    public List<BeanCombos> getDependenciaByComision(String periodo, Integer brigada, String mes, Integer tipoAsignacion) {
        return combosDAO.getDependenciaByComision(periodo, brigada, mes, tipoAsignacion);
    }

    @Override
    public List<BeanCombos> getVehiculoByComision(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer dependencia) {
        return combosDAO.getVehiculoByComision(periodo, brigada, mes, tipoAsignacion, dependencia);
    }

    @Override
    public List<BeanCombos> getCombustibleByComision(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer dependencia, Integer vehiculo) {
        return combosDAO.getCombustibleByComision(periodo, brigada, mes, tipoAsignacion, dependencia, vehiculo);
    }

    @Override
    public List<BeanCombos> getGrifos() {
        return combosDAO.getGrifos();
    }

    @Override
    public List<BeanCombos> getUsuariosByPeriodoAndGrifoPendientes(String periodo, Integer grifo) {
        return combosDAO.getUsuariosByPeriodoAndGrifoPendientes(periodo, grifo);
    }

}
