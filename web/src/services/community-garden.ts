import { api } from "./api";

export interface CommunityGardenInfo {
  id: string
  name: string;
  latitude: number;
  longitude: number;
  about: string;
  instructions: string;
  opening_hours: string;
  whatsapp: string;
  open_on_weekends: boolean;
  images: { url: string }[];
}

export const allCommunityGarden = async () => {
  const response = await api.get<CommunityGardenInfo[]>("/community-garden");
  return response.data;
}

export const communityGardenById = async (id: string) => {
  const response = await api.get<CommunityGardenInfo>(`/community-garden/${id}`);
  return response.data;
}

export const createCommunityGarden = async (body: any): Promise<void> => {
  api.post("/community-garden", body);
}