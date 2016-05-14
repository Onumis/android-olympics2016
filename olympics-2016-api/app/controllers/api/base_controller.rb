class Api::BaseController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :null_session

  respond_to :json

  rescue_from Exception, with: :generic_exception
  rescue_from ActiveRecord::RecordNotFound, with: :record_not_found

  private
  def generic_exception(error)
    logger.error error.message
    logger.error error.backtrace.join("\n")
    respond_to do |format|
      format.json { render json: { error: error.message }, status: 500 }
    end
  end

  def record_not_found(error)
    logger.error error.message
    logger.error error.backtrace.join("\n")
    respond_to do |format|
      format.json { render json: { error: error.message }, status: 404 }
    end
  end
end
