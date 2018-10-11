package portafolio.gpvh.model.service;

import portafolio.gpvh.model.entity.Documento;

import java.util.List;

public interface DocumentoService {

    public List<Documento> findAll();
    public void save(Documento documento);
    public Documento findOne(int id);
    public void delete(Documento documento);

}
