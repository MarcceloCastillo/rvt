import { BrowserRouter, Route, Routes as ReactRoutes } from 'react-router-dom';

import { Landing } from "./pages/landing";
import { CommunityGardenMap } from "./pages/community-garden-map";
import { CreateCommunityGarden } from "./pages/create-community-garden";
import { CommunityGarden } from "./pages/community-garden";

export const Routes = () => {
  return (
    <BrowserRouter>
      <ReactRoutes>
        <Route path="/" element={<Landing />} />
        <Route path="/app" element={<CommunityGardenMap />} />
        <Route path="/community-garden/create" element={<CreateCommunityGarden />} />
        <Route path="/community-garden/:community_garden_id" element={<CommunityGarden />} />
      </ReactRoutes>
    </BrowserRouter>
  )
} 