Rails.application.routes.draw do

  ActiveAdmin.routes(self)
  namespace :api, defaults: { format: 'json' } do
    get '/search' => 'search#search'
    resources :news, only: [:index]
    resources :moladities, only: [:index, :show]
    resources :athletes, only: [:index, :show]
    resources :transmissions, only: [:index]
  end

end
