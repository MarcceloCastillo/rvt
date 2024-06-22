import { useEffect, useState } from 'react';
import { useParams } from "react-router-dom";
import { FaWhatsapp } from 'react-icons/fa';
import { FiClock, FiInfo } from 'react-icons/fi';

import { Marker } from 'react-leaflet';

import { Sidebar } from "../../components/sidebar";

import './styles.css';

import { markerIcon } from "../../utils/maps";
import { Map } from "../../components/map";
import { CommunityGardenInfo, communityGardenById } from "../../services/community-garden";
import { Button } from "../../components/button";

type CommunityGardenRouteParams = {
  community_garden_id?: string;
}

export const CommunityGarden = () => {
  const [communityGarden, setCommunityGarden] = useState<CommunityGardenInfo>();
  const [selectedImageIndex, setSelectedImageIndex] = useState(0);

  const { community_garden_id: community_garden_id } = useParams<CommunityGardenRouteParams>()

  useEffect(() => {
    if (community_garden_id) {
      communityGardenById(community_garden_id)
        .then((response) => setCommunityGarden(response))
    }
    
  }, [community_garden_id]);

  if (!communityGarden) {
    return <p>Carregando Horta comunitária ...</p>
  }

  return (
    <div id="page-community-garden">
      <Sidebar />

      <main>
        <div className="community-garden-details">

          {communityGarden.images.length && (
            <img
              src={communityGarden.images[selectedImageIndex].url}
              alt={communityGarden.name}
            />
          )}

          <div className="images">
            {communityGarden.images.map((image, index) => {
              return (
                <button
                  key={image.url}
                  className={selectedImageIndex === index ? 'active' : ''}
                  type="button"
                  onClick={() => {
                    setSelectedImageIndex(index);
                  }}
                >
                  <img src={image.url} alt={communityGarden.name} />
                </button>
              );
            })}
          </div>

          <div className="community-garden-details-content">
            <h1>{communityGarden.name}</h1>
            <p>{communityGarden.about}</p>

            <div className="map-container">
              <Map
                interactive={false}
                center={[communityGarden.latitude, communityGarden.longitude]}
                zoom={16}
                style={{ width: '100%', height: 280 }}
              >
                <Marker
                  interactive={false}
                  icon={markerIcon()}
                  position={[communityGarden.latitude, communityGarden.longitude]}
                />
              </Map>

              <footer>
                <a
                  target="_blank"
                  rel="noopener noreferrer"
                  href={`https://www.google.com/maps/dir/?api=1&destination=${communityGarden.latitude},${communityGarden.longitude}`}
                >
                  Ver rotas no Google Maps
                </a>
              </footer>
            </div>

            <hr />

            <h2>Instruções para visita</h2>
            <p>{communityGarden.instructions}</p>

            <div className="open-details">
              <div className="hour">
                <FiClock size={32} color="#15B6D6" />
                Segunda à Sexta
                <br />
                {communityGarden.opening_hours}
              </div>

              {communityGarden.open_on_weekends ? (
                <div className="open-on-weekends">
                  <FiInfo size={32} color="#39CC83" />
                  Atendemos
                  <br />
                  fim de semana
                </div>
              ) : (
                <div className="open-on-weekends dont-open">
                  <FiInfo size={32} color="#FF669D" />
                  Não atendemos
                  <br />
                  fim de semana
                </div>
              )}
            </div>
            <a
              rel="noopener noreferrer"
              href={`https://api.whatsapp.com/send?phone=55${communityGarden.whatsapp}&text=Olá, gostaria de informações adicionais sobre a horta comunitária`}
              target="_blank"
            >
              <Button type="button">
                <FaWhatsapp size={20} color="#FFF" />
                Entrar em contato
              </Button>
            </a>
          </div>
        </div>
      </main>
    </div>
  )
}